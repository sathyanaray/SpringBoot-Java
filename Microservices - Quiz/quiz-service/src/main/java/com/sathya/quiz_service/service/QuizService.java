package com.sathya.quiz_service.service;

//import com.sathya.dao.QuestionDao;
import com.sathya.quiz_service.feign.QuizInterface;
import com.sathya.quiz_service.model.Question;
import com.sathya.quiz_service.model.QuestionWrapper;
import com.sathya.quiz_service.model.Quiz;
import com.sathya.quiz_service.model.Response;
import com.sathya.quiz_service.dao.QuizDao;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

   List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
   Quiz quiz = new Quiz();
   quiz.setTitle(title);
   quiz.setQuestionsIds(questions);
   quizDao.save(quiz);
    return new ResponseEntity<>("Success", HttpStatus.CREATED);
    };

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz= quizDao.findById(id).get();
        List<Integer> questionsIds = quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionsIds);

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
       ResponseEntity<Integer> score =  quizInterface.getScore(responses);
        return score;
    }
}

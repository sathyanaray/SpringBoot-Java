package com.sathya.questions_service.dao;

import com.sathya.questions_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id from questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}

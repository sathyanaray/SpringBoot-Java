package com.sathya.questions_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

}

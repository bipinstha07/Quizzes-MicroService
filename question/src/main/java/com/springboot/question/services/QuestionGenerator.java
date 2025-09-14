package com.springboot.question.services;

import com.springboot.question.dto.QuestionDto;
import com.springboot.question.functions.QuizDto;

import java.util.List;

public interface QuestionGenerator {


    List<QuestionDto> generateQuestions(String quizName,int numberOfQuestion,String description);

    void generateAndSave(QuizDto quizDto);

}

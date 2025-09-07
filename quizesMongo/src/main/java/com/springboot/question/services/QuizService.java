package com.springboot.question.services;

import com.springboot.question.dto.QuizDto;

import java.util.List;

public interface QuizService {
    QuizDto create(QuizDto quizDto);
    QuizDto update(String quizId,QuizDto quizDto);
    void delete(String quizId);
    List<QuizDto> findAll();

    QuizDto findById(String quizID);
    List<QuizDto> findByCategory(String categoryId);

}

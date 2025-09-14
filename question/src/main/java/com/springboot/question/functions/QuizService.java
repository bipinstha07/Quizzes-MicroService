package com.springboot.question.functions;

import com.springboot.question.services.QuestionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class QuizService {

    @Autowired
    private QuestionGenerator questionGenerator;


    @Bean
    public Function<QuizDto,String> getQuizBinding() {
        return quizDto -> {
            questionGenerator.generateAndSave(quizDto);
            System.out.println(quizDto.getTitle());
            return "HI";
        };
    }


}

package com.springboot.question.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class QuizService {

    @Bean
    public Consumer<QuizDto> getQuizBinding(){
        return quizDto -> System.out.println(quizDto.getTitle());
    }

}

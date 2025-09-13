package com.springboot.question.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class QuizService {

    @Bean
    public Function<QuizDto,String> getQuizBinding() {
        return quizDto -> {
            System.out.println(quizDto.getTitle());
            return "HI";
        };
    }


}

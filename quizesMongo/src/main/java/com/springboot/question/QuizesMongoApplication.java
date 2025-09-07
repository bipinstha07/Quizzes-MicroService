package com.springboot.question;

import com.springboot.question.respository.QuizMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizesMongoApplication  {
	@Autowired
	private QuizMongoRepo quizMongoRepo;

	public static void main  (String[] args) {
		SpringApplication.run(QuizesMongoApplication.class, args);
	}

}

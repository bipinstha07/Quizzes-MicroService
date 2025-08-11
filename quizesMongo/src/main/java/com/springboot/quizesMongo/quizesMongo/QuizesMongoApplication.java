package com.springboot.quizesMongo.quizesMongo;

import com.springboot.quizesMongo.quizesMongo.collections.Quiz;
import com.springboot.quizesMongo.quizesMongo.respository.QuizMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class QuizesMongoApplication  {
	@Autowired
	private QuizMongoRepo quizMongoRepo;

	public static void main  (String[] args) {
		SpringApplication.run(QuizesMongoApplication.class, args);
	}

}

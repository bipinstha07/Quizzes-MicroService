package com.springboot.question.repository;

import com.springboot.question.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<Question,String> {
}

package com.springboot.quizesMongo.respository;

import com.springboot.quizesMongo.collections.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizMongoRepo extends MongoRepository<Quiz,String> {

    List<Quiz> findByTitle(String title);
    List<Quiz> findByCategoryId(String categoryId);

}

package com.springboot.question.services;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "question-service",url = "lb://localhost:9093")
public interface QuestionService {


}

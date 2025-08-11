package com.springboot.quizesMongo.quizesMongo.controller;

import com.springboot.quizesMongo.quizesMongo.dto.QuizDto;
import com.springboot.quizesMongo.quizesMongo.services.CategoryService;
import com.springboot.quizesMongo.quizesMongo.services.QuizService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto){
        QuizDto quizDto1 = quizService.create(quizDto);
        return new ResponseEntity<>(quizDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<QuizDto>> getAllQuiz(){
        return new ResponseEntity<>(quizService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{quizId}")
    public void deletequiz(@PathVariable String quizId){
        quizService.delete(quizId);
    }


    @PutMapping("{quizId}")
    public ResponseEntity<QuizDto> update(@PathVariable String quizId, @RequestBody QuizDto quizDto){
        return new ResponseEntity<>(quizService.update(quizId,quizDto),HttpStatus.OK);
    }


    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable String quizId){
        return new ResponseEntity<>(quizService.findById(quizId),HttpStatus.OK);
    }

//    Get Quiz by Category ID using WebClient
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<QuizDto>> getQuizbyCategory(@PathVariable String categoryId){
        return new ResponseEntity<>(quizService.findByCategory(categoryId),HttpStatus.OK);
    }




}

package com.springboot.quiz.category.category_service.controller;

import com.springboot.quiz.category.category_service.dto.CategoryDto;
import com.springboot.quiz.category.category_service.entity.Category;
import com.springboot.quiz.category.category_service.service.CategoryInter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RefreshScope
//RefreshScope annotation for refreshing the changes in config files on instance, it will show on config server without this though
public class CategoryController {

    private CategoryInter categoryInter;

    @Value("${config.value}")
    private String value;

    public CategoryController(CategoryInter categoryInter) {
        this.categoryInter = categoryInter;
    }

    @PostMapping()
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = categoryInter.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    @GetMapping("/check")
    public ResponseEntity<String> getCheck(){

        return new ResponseEntity<>(value,HttpStatus.OK);
    }


    @PostMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@PathVariable String categoryId, @RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = categoryInter.update(categoryId,categoryDto);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getOne(@PathVariable String categoryId){
        CategoryDto categoryDto = categoryInter.getOne(categoryId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable String categoryId){
        categoryInter.delete(categoryId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAll(){
        List<CategoryDto> categoryDtos = categoryInter.getAll();
        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }


}

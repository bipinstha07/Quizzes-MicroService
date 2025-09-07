package com.springboot.question.services;

import com.springboot.question.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "CATEGORY-SERVICE")
public interface CategoryServiceFeign {

    @GetMapping("/categories/getAll")
    List<CategoryDto> findAll();

    @GetMapping("/categories/{categoryId}")
    CategoryDto findByCategoryId(@PathVariable String categoryId);

    @PostMapping("/categories")
    CategoryDto create(@RequestBody CategoryDto categoryDto);


}

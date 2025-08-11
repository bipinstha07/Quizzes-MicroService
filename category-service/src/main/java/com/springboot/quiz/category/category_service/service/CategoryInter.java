package com.springboot.quiz.category.category_service.service;

import com.springboot.quiz.category.category_service.dto.CategoryDto;

import java.util.List;

public interface CategoryInter {
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto update(String categoryId,CategoryDto categoryDto);
    CategoryDto getOne(String categoryId);
    void delete(String categoryId);
    List<CategoryDto> getAll();

}

package com.springboot.question.services;

import com.springboot.question.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(String categoryId);
    List<CategoryDto> findAll();
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto update(String categoryId,CategoryDto categoryDto);
    void delete(String categoryId);


}

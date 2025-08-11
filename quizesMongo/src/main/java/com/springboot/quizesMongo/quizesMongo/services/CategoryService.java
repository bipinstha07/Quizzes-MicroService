package com.springboot.quizesMongo.quizesMongo.services;

import com.springboot.quizesMongo.quizesMongo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(String categoryId);
    List<CategoryDto> findAll();
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto update(String categoryId,CategoryDto categoryDto);
    void delete(String categoryId);


}

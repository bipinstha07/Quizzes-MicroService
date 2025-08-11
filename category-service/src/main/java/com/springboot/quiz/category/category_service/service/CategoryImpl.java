package com.springboot.quiz.category.category_service.service;

import com.springboot.quiz.category.category_service.dto.CategoryDto;
import com.springboot.quiz.category.category_service.entity.Category;
import com.springboot.quiz.category.category_service.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class CategoryImpl implements CategoryInter{

    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;


    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        category.setId(UUID.randomUUID().toString());
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory,CategoryDto.class);

    }

    @Override
    public CategoryDto update(String categoryId,CategoryDto categoryDto) {

        Category category = categoryRepo.findById(categoryId);

        if(category == null){
            throw new RuntimeException("No Category Found");
        }

        category.setActive(categoryDto.isActive());
        category.setDescription(categoryDto.getDescription());
        category.setTitle(categoryDto.getTitle());
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto getOne(String categoryId) {
        Category category = categoryRepo.findById(categoryId);
        if(category == null){
            throw new RuntimeException("No Category Found");
        }

        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {
        Category category = categoryRepo.findById(categoryId);
        if(category == null){
            throw new RuntimeException("No Category Found");
        }
        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDto> getAll() {
       List<Category> allCategory = categoryRepo.findAll();
       List<CategoryDto> allCategoryDto = allCategory.stream().map((a)->modelMapper.map(a,CategoryDto.class)).toList();
       return allCategoryDto;
    }
}

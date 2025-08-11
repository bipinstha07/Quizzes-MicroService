package com.springboot.quiz.category.category_service.repository;

import com.springboot.quiz.category.category_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findById(String categoryId);

}

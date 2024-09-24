package com.example.fifotech.services.admin.category;

import com.example.fifotech.dto.CategoryDto;
import com.example.fifotech.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createcategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}

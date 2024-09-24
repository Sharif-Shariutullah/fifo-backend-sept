package com.example.fifotech.controller.admin;


import com.example.fifotech.dto.CategoryDto;
import com.example.fifotech.entity.Category;
import com.example.fifotech.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AdminCategoryController {

    private final CategoryService categoryService;


    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestParam("name") String name, @RequestParam("description") String description) {


        Category category = categoryService.createcategory(new CategoryDto(name, description));
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    ;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());

    }

}

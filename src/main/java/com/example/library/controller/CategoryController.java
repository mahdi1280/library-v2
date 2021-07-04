package com.example.library.controller;

import com.example.library.model.dto.CategoryDto;
import com.example.library.model.entity.Category;
import com.example.library.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Category add(@RequestBody CategoryDto categoryDto) {
        return categoryService.add(categoryDto);
    }

    @PostMapping("/update/{id}")
    public Category update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        return categoryService.update(id, categoryDto);
    }

    @GetMapping("/show")
    public Page<Category> show(Pageable pageable) {
        return categoryService.show(pageable);
    }
}

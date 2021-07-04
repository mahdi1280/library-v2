package com.example.library.service;

import com.example.library.Repository.CategoryRepo;
import com.example.library.model.dto.CategoryDto;
import com.example.library.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepo.save(category);
    }

    public Page<Category> show(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    public Category update(Long id, CategoryDto categoryDto) {
        Category category1=categoryRepo.findById(id).orElse(null);
        if(category1 != null){
            category1.setName(categoryDto.getName());
            return categoryRepo.save(category1);
        }
        return  null;
    }


}

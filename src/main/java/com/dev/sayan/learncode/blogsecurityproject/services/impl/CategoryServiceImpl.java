package com.dev.sayan.learncode.blogsecurityproject.services.impl;

import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.repositories.CategoryRepository;
import com.dev.sayan.learncode.blogsecurityproject.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Categrory exists");
        }
        return categoryRepository.save(category);
    }
}

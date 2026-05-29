package com.dev.sayan.learncode.blogsecurityproject.services.impl;

import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.repositories.CategoryRepository;
import com.dev.sayan.learncode.blogsecurityproject.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            if(category.get().getPosts().size()>0){
                throw new IllegalStateException("Category has posts assocuiated wityh it");
            }
            categoryRepository.deleteById(id);
        }
    }
}

package com.dev.sayan.learncode.blogsecurityproject.services;

import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> listAllCategories();

    Category createCategory(Category category);

    void deleteCategory(UUID id);
}

package com.dev.sayan.learncode.blogsecurityproject.services;

import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Post;

import java.util.List;

public interface CategoryService {
    List<Category> listAllCategories();

    Category createCategory(Category category);
}

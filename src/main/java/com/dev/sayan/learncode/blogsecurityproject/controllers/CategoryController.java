package com.dev.sayan.learncode.blogsecurityproject.controllers;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.CategoryDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.CreateCategoryRequestDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.mapper.CategoryMapper;
import com.dev.sayan.learncode.blogsecurityproject.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/allCategories")
    public ResponseEntity<List<CategoryDto>> listAllCatgeories(){
        List<CategoryDto> categories = categoryService.listAllCategories()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequestDto categoryRequestDto){
        Category toBeCreatedCategory = categoryMapper.toEntity(categoryRequestDto);
        return new ResponseEntity<>(categoryMapper.toDto(categoryService.createCategory(toBeCreatedCategory)), HttpStatus.CREATED);
    }
}

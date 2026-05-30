package com.dev.sayan.learncode.blogsecurityproject.services;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.TagResponseDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {
    List<Tag> getAllTags();
    List<Tag> createTags(Set<String> tagNames);

    void deleteTagById(UUID id);
}

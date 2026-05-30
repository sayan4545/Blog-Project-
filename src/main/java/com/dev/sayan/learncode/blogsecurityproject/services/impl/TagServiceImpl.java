package com.dev.sayan.learncode.blogsecurityproject.services.impl;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.TagResponseDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Tag;
import com.dev.sayan.learncode.blogsecurityproject.repositories.TagRepository;
import com.dev.sayan.learncode.blogsecurityproject.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAllByPostCount();
    }

    @Override
    @Transactional
    public List<Tag> createTags(Set<String> tagNames) {
        List<Tag> existingTags = tagRepository.findByNameIn(tagNames);
        Set<String> existingTagSets = existingTags.stream().map(Tag::getName).collect(Collectors.toSet());
        List<Tag> newTags = tagNames.stream()
                .filter(name-> !existingTagSets.contains(name))
                .map(name-> Tag.builder()
                        .name(name)
                        .posts(new HashSet<>())
                        .build())
                .toList();

        List<Tag> savedTags = new ArrayList<>();
        if(!newTags.isEmpty()){
            savedTags = tagRepository.saveAll(newTags);
        }
        return savedTags;
    }

    @Override
    @Transactional
    public void deleteTagById(UUID id) {
        tagRepository.findById(id).ifPresent(tag->{
            if(!(tag.getPosts().size() >0)){
                throw new IllegalStateException("There are post associated with the tag");
            }
            tagRepository.deleteById(id);
        });
    }
}

package com.dev.sayan.learncode.blogsecurityproject.controllers;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.TagRequestDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.TagResponseDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Tag;
import com.dev.sayan.learncode.blogsecurityproject.mapper.TagMapper;
import com.dev.sayan.learncode.blogsecurityproject.services.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1.0/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping("/allTags")
    public ResponseEntity<List<TagResponseDto>> getAllTags(){
        List<Tag> allTags = tagService.getAllTags();
        return new ResponseEntity<>(allTags.stream().map(tagMapper::toTagResponseDto).toList(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<TagResponseDto>> createTags(@Valid @RequestBody TagRequestDto tagRequestDto){
        List<Tag> tags = tagService.createTags(tagRequestDto.getNames());
        return new ResponseEntity<>(tags.stream()
                .map(tagMapper::toTagResponseDto)
                .toList(),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id){
        tagService.deleteTagById(id);
        return ResponseEntity.noContent().build();
    }
}

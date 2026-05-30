package com.dev.sayan.learncode.blogsecurityproject.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagResponseDto {
    private UUID id;
    private String name;
    private Integer postCount;
}

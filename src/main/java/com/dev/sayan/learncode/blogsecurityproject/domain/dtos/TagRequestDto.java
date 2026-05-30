package com.dev.sayan.learncode.blogsecurityproject.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagRequestDto {
    @NotEmpty
    @Size(max = 10)
    private Set<@Size(min = 2,max = 10) String> names;
}

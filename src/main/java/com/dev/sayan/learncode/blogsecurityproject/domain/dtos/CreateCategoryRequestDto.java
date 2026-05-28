package com.dev.sayan.learncode.blogsecurityproject.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequestDto {
    @NotBlank(message = "Category name cannot be blank")
    @Size(min = 2,max = 30)
    private String name;
}

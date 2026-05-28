package com.dev.sayan.learncode.blogsecurityproject.mapper;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.CategoryDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.CreateCategoryRequestDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Category;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Post;
import com.dev.sayan.learncode.blogsecurityproject.domain.enums.PostStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target= "postCount",source = "posts",qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto categoryRequestDto);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts){
        if(posts == null) return 0;
        return posts
                .stream()
                .filter(post-> PostStatus.PUBLISHED.equals(post.getPostStatus()))
                .count();
    }
}

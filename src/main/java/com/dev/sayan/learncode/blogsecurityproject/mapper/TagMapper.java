package com.dev.sayan.learncode.blogsecurityproject.mapper;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.TagResponseDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Post;
import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Tag;
import com.dev.sayan.learncode.blogsecurityproject.domain.enums.PostStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    @Mapping(target = "postCount",source = "posts",qualifiedByName = "calculatePostCount")
    TagResponseDto toTagResponseDto(Tag tag);

    @Named("calculatePostCount")
    default Integer calculatePostCount(Set<Post> posts){
        if(posts == null) return 0;
        return (int) posts
                .stream()
                .filter(post-> PostStatus.PUBLISHED.equals(post.getPostStatus()))
                .count();

    }
}

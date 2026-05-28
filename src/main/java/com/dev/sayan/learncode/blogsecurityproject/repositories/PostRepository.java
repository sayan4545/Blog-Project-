package com.dev.sayan.learncode.blogsecurityproject.repositories;

import com.dev.sayan.learncode.blogsecurityproject.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}

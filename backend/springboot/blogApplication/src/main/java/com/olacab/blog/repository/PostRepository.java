package com.olacab.blog.repository;

import com.olacab.blog.model.Post;
import com.olacab.blog.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post,Long> {
    Post findByPostId(Long postId);
}

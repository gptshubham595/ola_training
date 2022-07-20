package com.olacab.blog.controller;

import com.olacab.blog.model.Post;
import com.olacab.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @PostMapping(value = "/savepost",consumes = "application/json")
    public String savePost(@RequestBody Post post){
        postRepository.save(post);
        return "Posted successfully";
    }
}

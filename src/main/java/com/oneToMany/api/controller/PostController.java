package com.oneToMany.api.controller;

import com.oneToMany.api.model.Post;
import com.oneToMany.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {
  
  @Autowired
  private PostRepository postRepository;
  
  @GetMapping("/posts")
  public Page<Post> getAllPosts(Pageable pageable){
    return postRepository.findAll(pageable);
  }
  
  @PostMapping("/posts")
  public Post createPost(@RequestBody Post post){
    return postRepository.save(post);
  }
  
}

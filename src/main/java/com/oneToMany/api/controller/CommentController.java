package com.oneToMany.api.controller;


import com.oneToMany.api.exception.ApiException;
import com.oneToMany.api.model.Comment;
import com.oneToMany.api.model.Post;
import com.oneToMany.api.repository.CommentRepository;
import com.oneToMany.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
  
  @Autowired
  private CommentRepository commentRepository;
  
  @Autowired
  private PostRepository postRepository;
  
  
  //Get Comments // find comment by post id..
  @GetMapping("/posts/{postId}/comments")
  public Page<Comment> getAllComments(@PathVariable(value = "postId") Long postId, Pageable pageable) {
	return commentRepository.findByPostId(postId, pageable);
	
  }
  
  //Post Method for Comments.. only insert comment if post id exists
  @PostMapping("/posts/{postId}/comments")
  public Comment createComment(@PathVariable(value = "postId") Long id, @RequestBody Comment comment) throws ApiException {
	
	return postRepository.findById(id).map(post -> {
	  comment.setPost(post);
	  return commentRepository.save(comment);
	}).orElseThrow(() -> new ApiException("PostID" + id + "Not Found!"));
  }
  
  
  
  
}

package com.oneToMany.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends AuditModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Lob
  @Column(nullable = false)
  private  String text;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "post_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Post post;
  
  
  public Comment() {
  }
  
  public Long getId() {
	return id;
  }
  
  public void setId(Long id) {
	this.id = id;
  }
  
  public String getText() {
	return text;
  }
  
  public void setText(String text) {
	this.text = text;
  }
  
  public Post getPost() {
	return post;
  }
  
  public void setPost(Post post) {
	this.post = post;
  }
  
  @Override
  public String toString() {
	return "Comment{" +
			"id=" + id +
			", text='" + text + '\'' +
			", post=" + post +
			'}';
  }
}

package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.models.Post;
import com.example.blog.repository.PostRepository;

@Service
public class PostService {

   @Autowired
   PostRepository postRepository;

   
public Post CriarPost(Post post){
     return postRepository.save(post);
 }
}


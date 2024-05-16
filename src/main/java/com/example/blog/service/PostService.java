package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.models.Post;
import com.example.blog.repository.PostRepository;

@Service
public class PostService {

   @Autowired
   PostRepository postRepository;

   
public Post NovoPost(Post post){
     return postRepository.save(post);
 }



}


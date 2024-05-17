package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.blog.models.Post;
import com.example.blog.models.Usuario;
import com.example.blog.service.PostService;
import com.example.blog.service.UsuarioService;


@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PostService postService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> CriarUsuario(@RequestBody Usuario usuario) {
           try {
            Usuario salvandoUsuario = usuarioService.SalvarUsuario(usuario);
            return new ResponseEntity<>(salvandoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/criandoPost/{id}")
    public ResponseEntity<Post> CriandoPost(@PathVariable Long id , @RequestBody Post post) {
       try {
           Post NovoPost = usuarioService.CriarPost(id, post);
           return new ResponseEntity<>(NovoPost, HttpStatus.CREATED);
       } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    
    
}

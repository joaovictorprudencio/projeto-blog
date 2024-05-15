package com.example.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.blog.models.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
}

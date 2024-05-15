package com.example.blog.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.blog.models.Usuario;
import com.example.blog.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {
    
    @Mock
    UsuarioRepository usuarioRepository;
    
    @InjectMocks
    UsuarioService usuarioService;

   @Test
   void SalvarUsuarioTest(){
    Usuario usuarionovo = new Usuario();
    usuarionovo.setId((long)1);
    usuarionovo.setNome("joao victor prudencio");

     when(usuarioRepository.save(usuarionovo)).thenReturn(usuarionovo);

     Usuario UsuarioSalvo = usuarioService.SalvarUsuario(usuarionovo);

     assertEquals("joao victor prudencio", UsuarioSalvo.getNome());


      
    
   }




}

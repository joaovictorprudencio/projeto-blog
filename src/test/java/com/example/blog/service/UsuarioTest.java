package com.example.blog.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.blog.models.Post;
import com.example.blog.models.Usuario;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {
    
    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    PostRepository postRepository;

    
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

   @Test
   void CriarPost (){

    Usuario usuario = new Usuario();
    usuario.setId((long)1);
    usuario.setNome("joao victor prudencio");

    when(usuarioRepository.findById((long)1)).thenReturn(Optional.of(usuario));

   
    Post novoPost = new Post();
    novoPost.setId((long)1);
    novoPost.setTitulo("titulo");
    novoPost.setConteudo("post criado usando a api do joão victor");

    when(postRepository.save(novoPost)).thenReturn(novoPost);

    
        Post resultado = usuarioService.CriarPost((long)1, novoPost);

        
        verify(usuarioRepository).findById((long) 1);
        verify(postRepository).save(novoPost);

        
        assertNotNull(resultado);
        assertEquals("titulo", resultado.getTitulo());
        assertEquals("post criado usando a api do joão victor", resultado.getConteudo());
        assertEquals(usuario, resultado.getUsuario());   
    


   }




}

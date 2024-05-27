package com.example.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blog.models.Post;
import com.example.blog.models.Usuario;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
 
    @Autowired
    PostRepository postRepository;

    

    
    public Usuario SalvarUsuario(Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    public void DeletarUsuario(long id){
      usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> BuscarPorId(long id){
        return  usuarioRepository.findById(id);
    }  

    public Usuario AtualizarDados(long id ,Usuario UsuarioAtualizado){
        Optional<Usuario> UsuarioOptional = BuscarPorId(id);
        Usuario UsuarioUpdate = UsuarioOptional.get();
        UsuarioUpdate.setNome(UsuarioAtualizado.getNome());
        return UsuarioUpdate;   
    }

    public Post CriarPost(Long id, Post post) {
        try {
            Optional<Usuario> usuarioOptional = BuscarPorId(id);
    
            if (usuarioOptional.isPresent()) {
                Usuario usuarioAutor = usuarioOptional.get();
                post.setUsuario(usuarioAutor);
                Post postCriado = postRepository.save(post);
                return postCriado;
            } else {
                throw new Exception("Usuário com ID " + id + " não encontrado");
            }
        }catch (Exception ex) {
            System.err.println("Erro ao criar post: " + ex.getMessage());
            return null;
        }
    }































    
   }


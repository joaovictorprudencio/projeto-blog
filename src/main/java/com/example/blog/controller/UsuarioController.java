package com.example.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.blog.models.Post;
import com.example.blog.models.Usuario;
import com.example.blog.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

   
    @Operation(summary = "criar um usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuario criado com sucesso"),
    @ApiResponse(responseCode = "504", description = "Erro na operação")
    })
    @PostMapping("/criar")
    public ResponseEntity<Usuario> CriarUsuario(@RequestBody Usuario usuario) {
           try {
            Usuario salvandoUsuario = usuarioService.SalvarUsuario(usuario);
            return new ResponseEntity<>(salvandoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Operation(summary = "Buscar um  Usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuario encontrado "),
    @ApiResponse(responseCode = "504", description = "Usuario não existe")
    })
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> BuscarUsuario(@PathVariable long id ){
        try{
            Optional<Usuario> UsuarioOptinal  = usuarioService.BuscarPorId(id);
            Usuario UsuarioExistente = UsuarioOptinal.get();
            return new ResponseEntity<>(UsuarioExistente , HttpStatus.OK);

        } catch (Exception erro){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //fazer commit amanha 

    }

    @Operation(summary = "postar um texto")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "post concluido com sucesso"),
    @ApiResponse(responseCode = "504", description = "Erro na operação")
    })
    @PostMapping("/novopost/{id}")
    public ResponseEntity<Post>NewPost(@PathVariable Long id,Post post ){
     try{
        usuarioService.CriarPost(id, post );
        return new ResponseEntity<>(post, HttpStatus.CREATED);

     }catch(Exception erro){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     }

    }





    
    
}

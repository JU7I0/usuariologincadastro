package com.jcbs.usuariologincadastro.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcbs.usuariologincadastro.application.dto.UsuarioRequestDTO;
import com.jcbs.usuariologincadastro.application.dto.UsuarioResponseDTO;
import com.jcbs.usuariologincadastro.application.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public UsuarioResponseDTO postUsuarios(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.save(usuarioRequestDTO);
    }

    @GetMapping("/logado")
    public String getLogado() {
        return "Logado com sucesso";
    }
    
}

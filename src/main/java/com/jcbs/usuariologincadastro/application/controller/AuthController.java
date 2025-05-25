package com.jcbs.usuariologincadastro.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcbs.usuariologincadastro.adapter.persistence.jpa.model.UsuarioEntity;
import com.jcbs.usuariologincadastro.application.config.TokenService;
import com.jcbs.usuariologincadastro.application.dto.AuthDTO;
import com.jcbs.usuariologincadastro.application.dto.LoginResponseDTO;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthDTO authDTO) {
        var usernamePassword =  new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}

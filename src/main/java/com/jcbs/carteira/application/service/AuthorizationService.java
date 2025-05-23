package com.jcbs.carteira.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jcbs.carteira.adapter.persistence.jpa.UsuarioRepositoryJpa;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsuarioRepositoryJpa repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}

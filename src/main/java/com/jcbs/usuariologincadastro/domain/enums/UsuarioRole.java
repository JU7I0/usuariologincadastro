package com.jcbs.usuariologincadastro.domain.enums;

public enum UsuarioRole {
    
    ADMIN("admin"),
    USER("user");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

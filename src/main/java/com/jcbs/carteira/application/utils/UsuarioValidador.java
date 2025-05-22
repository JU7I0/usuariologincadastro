package com.jcbs.carteira.application.utils;

import org.springframework.stereotype.Component;

import com.jcbs.carteira.adapter.persistence.jpa.UsuarioRepositoryJpaAdapter;
import com.jcbs.carteira.application.dto.UsuarioRequestDTO;
import com.jcbs.carteira.domain.model.Usuario;
@Component
public class UsuarioValidador {

    private final UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter;

    public UsuarioValidador(UsuarioRepositoryJpaAdapter usuarioRepositoryJpaAdapter) {
        this.usuarioRepositoryJpaAdapter = usuarioRepositoryJpaAdapter;
    }

    public void verificaUsuarioExistente(Usuario usuario) {
        if (usuarioRepositoryJpaAdapter.findByCpf(usuario.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado, por favor, verifique se sua conta está ativa!");
        }
        if (usuarioRepositoryJpaAdapter.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado, por favor, verifique se sua conta está ativa!");
        }
    }

    public void verificaUsuarioRequestDTO(UsuarioRequestDTO dto) {
        verificaCamposPresentes(dto);
        verificaCpf(dto.getCpf());
        verificaEmail(dto.getEmail());
        verificaSenha(dto.getSenha());
    }

    private void verificaCamposPresentes(UsuarioRequestDTO dto) {
        StringBuilder missingFields = new StringBuilder();
        String[] fieldNames = {"cpf", "email", "nome", "senha"};
        Object[] fieldValues = {dto.getCpf(), dto.getEmail(), dto.getNome(), dto.getSenha()};
        for (int i = 0; i < fieldNames.length; i++) {
            if (fieldValues[i] == null) {
                missingFields.append(fieldNames[i]).append(", ");
            }
        }
        if (missingFields.length() > 0) {
            missingFields.setLength(missingFields.length() - 2);
            throw new IllegalArgumentException("Os seguintes campos devem estar presentes: " + missingFields.toString() + ".");
        }
    }

    private void verificaCpf(String cpf) {
        if (!(cpf.length() == 11 || cpf.length() == 14) || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF deve ter 11 ou 14 dígitos numéricos.");
        }
    }

    private void verificaEmail(String email) {
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.(com|com\\.br)$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Email inválido. Exemplo: usuario@email.com ou usuario@email.com.br");
        }
    }

    private void verificaSenha(String senha) {
        StringBuilder senhaErros = new StringBuilder();
        if (senha.length() < 8) {
            senhaErros.append("A senha deve ter pelo menos 8 caracteres. ");
        }
        if (!senha.matches(".*[A-Z].*")) {
            senhaErros.append("A senha deve conter pelo menos uma letra maiúscula. ");
        }
        if (!senha.matches(".*[a-z].*")) {
            senhaErros.append("A senha deve conter pelo menos uma letra minúscula. ");
        }
        if (!senha.matches(".*\\d.*")) {
            senhaErros.append("A senha deve conter pelo menos um número. ");
        }
        if (!senha.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            senhaErros.append("A senha deve conter pelo menos um caractere especial (ex: !@#$%^&*()_+-=[]{};':\"\\|,.<>/?). ");
        }
        if (senhaErros.length() > 0) {
            throw new IllegalArgumentException(senhaErros.toString().trim());
        }
    }

}

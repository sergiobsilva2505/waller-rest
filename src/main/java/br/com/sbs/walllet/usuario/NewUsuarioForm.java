package br.com.sbs.walllet.usuario;

import javax.validation.constraints.NotBlank;

public record NewUsuarioForm(@NotBlank String nome, @NotBlank String login) {

    public Usuario toEntity() {
        return new Usuario(nome, login);
    }

}

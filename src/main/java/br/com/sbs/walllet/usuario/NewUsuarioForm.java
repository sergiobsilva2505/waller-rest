package br.com.sbs.walllet.usuario;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class NewUsuarioForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String login;

    @Deprecated
    public NewUsuarioForm() {
    }

    public Usuario toEntity() {
        return new Usuario(nome, login);
    }

}

package br.com.sbs.walllet.usuario;

import lombok.Getter;

import java.util.List;

@Getter
public class UsuarioDTO {

    private String nome;
    private String login;

    @Deprecated
    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
    }

    public static List<UsuarioDTO> fromEntity(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }
}

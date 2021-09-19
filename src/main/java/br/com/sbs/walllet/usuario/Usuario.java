package br.com.sbs.walllet.usuario;

import lombok.*;

import javax.persistence.*;
import java.util.Random;

@Getter
@ToString(exclude = {"senha"})
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String login) {
        this.nome = nome;
        this.login = login;
        this.senha = new Random().nextInt(999999) + "";
    }

}

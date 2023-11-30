package com.jp.SIDEA.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login = "";
    private String senha = "";
    private String nome = "";
    private String email = "";
    private String cargo = "";
    private String Tipo = "";
    @OneToOne
    private Telefone telefone;

    public Usuario(String login, String senha, String nome, String email){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
}

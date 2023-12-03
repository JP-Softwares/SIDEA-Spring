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
    @Column(unique = true)
    private String login = "";
    private String senha = "";
    private String nome = "";
    private String email = "";
    private String Tipo = "";
    private String telefone = "";

    public Usuario(String login, String senha, String nome, String email, String telefone){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public boolean isAnalista(Usuario logado){
        if(logado.getTipo().equals("denunciante")) return false;
        else return true;
    }
}

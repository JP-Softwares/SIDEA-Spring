package com.jp.SIDEA.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Analista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login = "";
    private String senha = "";
    private String nome = "";
    private String email = "";
    @OneToOne
    private Telefone telefone;
}

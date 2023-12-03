package com.jp.SIDEA.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_arquivo = "";
    @Lob
    private byte[] conteudo;
    @OneToOne
    private Denuncia denuncia_id;
    private String tipo_arquivo = "";
    private String nomeSemExtensao = "";
}

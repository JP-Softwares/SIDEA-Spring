package com.jp.SIDEA.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolo = "";
    private int sigilo;
    private String CEP;
    private String logradouro;
    private String bairro;
    private String municipio;
    private String referencia;
    private String latitude;
    private String longitude;
    private String atividade_categoria;
    private String descricao;
    private String outras_informacoes;
    private Date data_ocorrido;
    private Date data_denuncia;
    private Date data_encerramento;
    private String provavel_criminoso;
    @OneToOne
    private usuario autor;
    @OneToOne
    private usuario executor;
    private int status;
    private String parecer_tec;
}

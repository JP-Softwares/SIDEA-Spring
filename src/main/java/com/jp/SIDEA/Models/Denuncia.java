package com.jp.SIDEA.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private String atividade;
    private String categoria;
    private String descricao;
    private String outras_informacoes;
    private Date data_ocorrido;
    private Date data_denuncia;
    private Date data_encerramento;
    private String provavel_criminoso;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Usuario executor;
    private int status;
    private String parecer_tec;


    public Denuncia(int sigilo, String cep, String logradouro, String categoria,String atividade, String bairro, String municipio, String referencia, String latitude, String longitude, Date dataDoOcorrido, String descricao, String provavelCriminoso, String outrasInformacoes, Usuario autor){
        this.sigilo = sigilo;
        this.CEP = cep;
        this.logradouro = logradouro;
        this.atividade = atividade;
        this.categoria = categoria;
        this.bairro = bairro;
        this.municipio = municipio;
        this.referencia = referencia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data_ocorrido = dataDoOcorrido;
        this.descricao = descricao;
        this.provavel_criminoso = provavelCriminoso;
        this.outras_informacoes = outrasInformacoes;
        this.autor = autor;
    }

}

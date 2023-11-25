package com.jp.SIDEA.Models;


import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_arquivo = "";
    private Byte[] conteudo;
    private BigInteger tamanho;
    private String md5;
}

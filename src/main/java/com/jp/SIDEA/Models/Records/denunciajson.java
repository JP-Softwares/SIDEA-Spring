package com.jp.SIDEA.Models.Records;

import java.sql.Date;

public record denunciajson(int sigilo, String cep, String logradouro, String atividade, String categoria, String bairro, String municipio, String referencia, String latitude, String longitude, Date dataDoOcorrido, String descricao, String provavelCriminoso, String outrasInformacoes) {
}

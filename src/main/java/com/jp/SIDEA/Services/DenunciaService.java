package com.jp.SIDEA.Services;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denuncias;

    @Autowired
    private LogadoService logado;

    public Denuncia Salvar(denunciajson json){
        Denuncia den = new Denuncia();
        den.setSigilo(json.sigilo());
        den.setCEP(json.cep());
        den.setLogradouro(json.logradouro());
        den.setAtividade(json.atividade());
        den.setCategoria(json.categoria());
        den.setBairro(json.bairro());
        den.setMunicipio(json.municipio());
        den.setReferencia(json.referencia());
        den.setLatitude(json.latitude());
        den.setLongitude(json.longitude());
        den.setData_ocorrido(json.dataDoOcorrido());
        den.setDescricao(json.descricao());
        den.setProvavel_criminoso(json.provavelCriminoso());
        den.setOutras_informacoes(json.outrasInformacoes());
        den.setAutor(logado.getLogado());
        den.setData_denuncia(Date.valueOf(LocalDate.now()));
        Denuncia envio = denuncias.save(den);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        envio.setProtocolo(envio.getId()+"/"+year);
        denuncias.save(envio);
        return envio;
    }

}
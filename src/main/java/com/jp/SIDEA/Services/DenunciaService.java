package com.jp.SIDEA.Services;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jp.SIDEA.Models.Records.denunciajson;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denuncias;

    public Denuncia Salvar(denunciajson json){
        Denuncia den = new Denuncia();
        den.setSigilo(json.sigilo());

        return den;
    }

}
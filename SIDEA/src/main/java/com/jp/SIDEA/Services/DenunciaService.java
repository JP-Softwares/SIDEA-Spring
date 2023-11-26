package com.jp.SIDEA.Services;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denuncias;

    public Denuncia Salvar(Denuncia denuncia){
        Denuncia den = denuncias.save(denuncia);
        return den;
    }




}

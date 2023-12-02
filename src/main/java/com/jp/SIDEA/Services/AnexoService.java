package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Anexo;
import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Persistencia.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnexoService {
    @Autowired
    private AnexoRepository anexos;
    public Anexo Salvar(Anexo anexo){
        Anexo anex = anexos.save(anexo);
        return anex;
    }
}

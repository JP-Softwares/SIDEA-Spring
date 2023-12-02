package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Comentario;
import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Persistencia.ComentarioRepository;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarios;
    public Comentario Salvar(Comentario comentario){
        Comentario com = comentarios.save(comentario);
        return com;
    }
}

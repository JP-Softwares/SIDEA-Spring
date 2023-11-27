package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import com.jp.SIDEA.Persistencia.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarios;
    public Usuario Salvar(Usuario usuario){
        Usuario usu = usuarios.save(usuario);
        return usu;
    }
}

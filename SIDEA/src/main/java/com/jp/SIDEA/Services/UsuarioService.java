package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Models.Records.usuarioJson;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import com.jp.SIDEA.Persistencia.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarios;
    public Usuario Salvar(usuarioJson json){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(json.login());
        novoUsuario.setSenha(json.senha());
        novoUsuario.setNome(json.nome());
        novoUsuario.setEmail(json.email());
        Usuario usu = usuarios.save(novoUsuario);
        return usu;
    }
}

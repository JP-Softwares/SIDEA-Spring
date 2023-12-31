package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.loginJson;
import com.jp.SIDEA.Models.Records.usuario2Json;
import com.jp.SIDEA.Models.Records.usuarioJson;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Persistencia.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarios;

    @Autowired
    private CriptografiaService criptos;


    public Usuario Salvar(usuarioJson json) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(json.login());
        try{
            novoUsuario.setSenha(criptos.criptografar(json.senha()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        novoUsuario.setNome(json.nome());
        novoUsuario.setEmail(json.email());
        novoUsuario.setTelefone(json.telefone());
        novoUsuario.setTipo("denunciante");
        Usuario usu = usuarios.save(novoUsuario);
        return usu;
    }

    public Usuario atualizar(usuario2Json json, Long id){
        Optional<Usuario> atto = usuarios.findById(id);
        Usuario att = atto.get();
        att.setEmail(json.email());
        att.setTipo(json.tipo());
        att.setTelefone(json.telefone());
        att.setNome(json.nome());
        return usuarios.save(att);
    }

    public boolean BuscaPorLogin(loginJson json) throws Exception {
        Optional<Usuario> novoUsuario = Optional.ofNullable(usuarios.findByLogin(json.cpf()));
        if (novoUsuario.isPresent()) {
            Usuario newUser = usuarios.findByLogin(json.cpf());
            if (json.senha().equals(criptos.descriptografar(newUser.getSenha()))) {
                return true;
            }
            System.out.println(criptos.descriptografar(newUser.getSenha()));
        }
        return false;
    }

    public Usuario findByCPF(String cpf){
        Usuario newUser = usuarios.findByLogin(cpf);
        return  newUser;
    }

    public Usuario findById(Long id){
        Optional<Usuario> novoUsuario = usuarios.findById(id);
        return novoUsuario.get();
    }
    public List<Usuario> ListarTodos(){
        return usuarios.listarTodos().orElseGet(ArrayList::new);
    }

}

package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Models.Records.usuario2Json;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Services.LogadoService;
import com.jp.SIDEA.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private LogadoService logado;

    @Autowired
    private UsuarioService usuarios;

    @GetMapping("/controleUsuarios")
    public ModelAndView visualizarUsuarios() {
        ModelAndView modelinho = new ModelAndView("usuario/controleUsuarios");
        List<Usuario> listUser = usuarios.ListarTodos();
        modelinho.addObject("listUser", listUser);
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }

    @GetMapping("{id}/visualizar")
    public ModelAndView visualizarUsuario(@PathVariable Long id ) {
        ModelAndView modelinho = new ModelAndView("usuario/editarUsuario");
        Usuario usu = usuarios.findById(id);
        modelinho.addObject("usuario", usu);
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }

    @PostMapping("{id}/salvar")
    public ModelAndView SalvarUsuario(@ModelAttribute usuario2Json json,@PathVariable Long id){
        ModelAndView modelinho = new ModelAndView("usuario/controleUsuarios");
        usuarios.atualizar(json, id);
        List<Usuario> listUser = usuarios.ListarTodos();
        modelinho.addObject("listUser", listUser);
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }
}

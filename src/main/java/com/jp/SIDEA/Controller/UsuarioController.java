package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Services.LogadoService;
import com.jp.SIDEA.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

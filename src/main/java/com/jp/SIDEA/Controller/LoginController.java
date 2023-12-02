package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Records.loginJson;
import com.jp.SIDEA.Models.Records.usuarioJson;
import com.jp.SIDEA.Services.CriptografiaService;
import com.jp.SIDEA.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Login")
public class LoginController {


    @Autowired
    private UsuarioService usuarios;

    @Autowired
    private CriptografiaService criptos;



    @GetMapping
    public ModelAndView LoginView() throws Exception {
        ModelAndView modelinho = new ModelAndView("login/login");
        criptos.gerarChaveSecreta();
        return modelinho;
    }

    @PostMapping
    public ModelAndView LoginTry(@ModelAttribute loginJson json, HttpServletRequest request) throws Exception {
        if(usuarios.BuscaPorLogin(json) == true) {
            ModelAndView modelinho = new ModelAndView("redirect:/denuncia");
            return modelinho;
        }
        ModelAndView modelinho = new ModelAndView("login/login");
        return modelinho;
    }

    @GetMapping("/criarConta")
    public ModelAndView createView(){
        ModelAndView modelinho = new ModelAndView("login/criarConta");
        return modelinho;
    }

    @PostMapping("/criarConta")
    public ModelAndView create(@ModelAttribute usuarioJson json, HttpServletRequest request){
        usuarios.Salvar(json);
        ModelAndView modelinho = new ModelAndView("redirect:/Login");
        return modelinho;
    }
}

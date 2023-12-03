package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Services.LogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TelaInicialController {

    @Autowired
    private LogadoService logado;
    

    @GetMapping("/home")
    public ModelAndView homeView(){
        ModelAndView modelinho = new ModelAndView("home/home");
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }

    @GetMapping
    public ModelAndView redirect(){
        ModelAndView modelinho = new ModelAndView("redirect:/Login");
        return modelinho;
    }
}

package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Login")
public class LoginController {


    @GetMapping
    public ModelAndView denunciaView(){
        ModelAndView modelinho = new ModelAndView("login");
        return modelinho;
    }

    @GetMapping("/teste")
    public ModelAndView denunciaViewTeste(){
        ModelAndView modelinho = new ModelAndView("oi");
        return modelinho;
    }
}

package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TelaInicialController {
    

    @GetMapping
    public ModelAndView homeView(){
        ModelAndView modelinho = new ModelAndView("home");
        return modelinho;
    }
}

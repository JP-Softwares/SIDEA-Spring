package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TelaInicialController {
    

    @GetMapping("/home")
    public ModelAndView homeView(){
        ModelAndView modelinho = new ModelAndView("home/home");
        return modelinho;
    }

    @GetMapping
    public ModelAndView redirect(){
        ModelAndView modelinho = new ModelAndView("redirect:/Login");
        return modelinho;
    }
}

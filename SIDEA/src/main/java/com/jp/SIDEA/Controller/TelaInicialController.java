package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Home")
public class TelaInicialController {
    

    @GetMapping
    public ModelAndView homeView(){
        ModelAndView modelinho = new ModelAndView("Home/index");
        return modelinho;
    }
}

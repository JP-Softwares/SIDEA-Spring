package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jp.SIDEA.Models.Telefone;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {


    
    @GetMapping
    public ModelAndView denunciaView(){
        ModelAndView modelinho = new ModelAndView("oi");
        modelinho.addObject("frase", "Quando a educação não é libertadora, o sonho do oprimido é se tornar o opressor");
        return modelinho;
    }
}

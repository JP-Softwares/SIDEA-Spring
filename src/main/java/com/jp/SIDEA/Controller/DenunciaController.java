package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Records.loginJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import com.jp.SIDEA.Models.Telefone;
import com.jp.SIDEA.Models.Records.denunciajson;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {
    
    @GetMapping
    public ModelAndView denunciaView(){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncia");
        return modelinho;
    }

    @PostMapping
    public ModelAndView denunciaView(@ModelAttribute denunciajson json){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncia");
        return modelinho;
    }
}

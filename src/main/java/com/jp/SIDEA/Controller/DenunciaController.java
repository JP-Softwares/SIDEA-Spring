package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Services.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {


    @Autowired
    private DenunciaService denuncias;

    
    @GetMapping
    public ModelAndView denunciaView(){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncia");
        return modelinho;
    }

    @PostMapping
    public ModelAndView denunciaView(@ModelAttribute denunciajson json,  @RequestParam("imagem") MultipartFile imagem) throws IOException {
        denuncias.Salvar(json,imagem);
        ModelAndView modelinho = new ModelAndView("redirect:/home");
        return modelinho;
    }

    @GetMapping("/visualizar")
    public ModelAndView visualizarDenuncia(){
        ModelAndView modelinho = new ModelAndView("denuncia/visualizarDenuncia");
        return modelinho;
    }
}

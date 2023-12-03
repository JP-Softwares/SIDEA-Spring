package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Services.DenunciaService;
import com.jp.SIDEA.Services.LogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {


    @Autowired
    private DenunciaService denuncias;

    @Autowired
    private LogadoService logado;

    
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
        if(logado.getLogado().getTipo().equals("denunciante")){
            List<Denuncia> listDen = denuncias.ListarPorUser(logado.getLogado());
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }else{
            List<Denuncia> listDen = denuncias.ListarTodos();
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }
        return modelinho;
    }

    @GetMapping("/visualizar/abertas")
    public ModelAndView visualizarDenunciasAbertas(){
        ModelAndView modelinho = new ModelAndView("denuncia/visualizarDenuncia");
        List<Denuncia> listDen = denuncias.ListarAbertas();
        modelinho.addObject("ListDen", listDen);
        return modelinho;
    }
}

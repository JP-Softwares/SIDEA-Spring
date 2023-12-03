package com.jp.SIDEA.Controller;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denuncia2json;
import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Models.Records.filtroJson;
import com.jp.SIDEA.Services.AnexoService;
import com.jp.SIDEA.Services.DenunciaService;
import com.jp.SIDEA.Services.LogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private AnexoService anexos;

    
    @GetMapping
    public ModelAndView denunciaView(){
        ModelAndView modelinho = new ModelAndView("denuncia/novaDenuncia");
        return modelinho;
    }

    @PostMapping
    public ModelAndView denunciaView(@ModelAttribute denunciajson json,  @RequestParam("imagem") MultipartFile imagem) throws IOException {
        denuncias.Salvar(json,imagem);
        ModelAndView modelinho = new ModelAndView("redirect:/home");
        return modelinho;
    }

    @GetMapping("/visualizar")
    public ModelAndView visualizarDenuncias(){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncias");
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


    @PostMapping("/visualizar")
    public ModelAndView visualizarFiltradas(@ModelAttribute filtroJson json){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncias");
        if(logado.getLogado().getTipo().equals("denunciante")){
            List<Denuncia> listDen = denuncias.ListarPorUser(logado.getLogado());
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }else{
            List<Denuncia> listDen = denuncias.ListarFiltradasTotal(json);
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }
        return modelinho;
    }




    @GetMapping("{id}/visualizar/imagem")
    @ResponseBody
    public ResponseEntity<byte[]> exibirImagem(@PathVariable Long id){
        return anexos.obterImagem(id);
    }

    @GetMapping("{id}/visualizar")
    public ModelAndView visualizarDenuncia(@PathVariable Long id ) {
        ModelAndView modelinho = new ModelAndView("denuncia/visualizarDenuncia");
        Denuncia den = denuncias.obter(id);
        modelinho.addObject("denuncia", den);
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }

    @PostMapping("{id}/visualizar/salvar")
    public ModelAndView atualizarDenuncia(@PathVariable Long id, @ModelAttribute denuncia2json json){
        ModelAndView modelinho = new ModelAndView("denuncia/denuncias");
        denuncias.atualizar(json, id);
        if(logado.getLogado().getTipo().equals("denunciante")){
            List<Denuncia> listDen = denuncias.ListarPorUser(logado.getLogado());
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }else{
            List<Denuncia> listDen = denuncias.ListarTodos();
            modelinho.addObject("ListDen", listDen);
            modelinho.addObject("logado", logado.getLogado());
        }
        modelinho.addObject("logado", logado.getLogado());
        return modelinho;
    }
}

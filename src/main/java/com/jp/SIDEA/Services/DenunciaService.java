package com.jp.SIDEA.Services;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denuncia2json;
import com.jp.SIDEA.Models.Records.denunciajson;
import com.jp.SIDEA.Models.Records.filtroJson;
import com.jp.SIDEA.Models.Usuario;
import com.jp.SIDEA.Persistencia.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denuncias;

    @Autowired
    private LogadoService logado;

    @Autowired
    private AnexoService imagens;

    @Autowired UsuarioService usuario;

    public Denuncia Salvar(denunciajson json, MultipartFile imagem) throws IOException {
        Denuncia den = new Denuncia();
        den.setSigilo(json.sigilo());
        den.setCEP(json.cep());
        den.setLogradouro(json.logradouro());
        den.setCategoria(json.atividade());
        den.setAtividade(json.categoria());
        den.setBairro(json.bairro());
        den.setMunicipio(json.municipio());
        den.setReferencia(json.referencia());
        den.setLatitude(json.latitude());
        den.setLongitude(json.longitude());
        den.setData_ocorrido(json.dataDoOcorrido());
        den.setDescricao(json.descricao());
        den.setProvavel_criminoso(json.provavelCriminoso());
        den.setOutras_informacoes(json.outrasInformacoes());
        den.setAutor(logado.getLogado());
        den.setData_denuncia(Date.valueOf(LocalDate.now()));
        den.setStatus("Aguardando atendimento");
        Denuncia envio = denuncias.save(den);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        envio.setProtocolo(envio.getId()+"/"+year);
        imagens.Salvar(imagem, den);
        denuncias.save(envio);
        return envio;
    }

    public List<Denuncia> ListarPorUser(Usuario user){
        return denuncias.listarTodosDoUsuario(usuario.findByCPF(logado.getLogado().getLogin())).orElseGet(ArrayList::new);
    }

    public List<Denuncia> ListarTodos(){
        return denuncias.listarTodos().orElseGet(ArrayList::new);
    }

    public List<Denuncia> ListarFiltradasDenunciante(filtroJson json, String filtro) {
        if (!logado.getLogado().getTipo().equals("denunciante")) {
            System.out.println("teste");
            switch (filtro) {
                case "protocolo":
                    System.out.println(json.filtro());
                    return denuncias.listarProtcoloAnalista(json.filtro()).orElseGet(ArrayList::new);
                case "municipio":
                    return denuncias.listarMunicipioAnalista(json.filtro()).orElseGet(ArrayList::new);
                case "categoria":
                    return denuncias.listarCategoriaAnalista(json.filtro()).orElseGet(ArrayList::new);
                case "data_ocorrencia":
                    Date data = Date.valueOf(json.filtro());
                    return denuncias.listarData_ocorridoAnalista(data).orElseGet(ArrayList::new);
                case "data_denuncia":
                    Date data2 = Date.valueOf(json.filtro());
                    return denuncias.listarData_denunciaAnalista(data2).orElseGet(ArrayList::new);
                case "status":
                    System.out.println(json.filtro());
                    return denuncias.listarStatusAnalista(json.filtro()).orElseGet(ArrayList::new);
            }
        } else {
            switch (filtro) {
                case "protocolo":
                    return denuncias.listarProtcoloDenunciante(json.filtro(), logado.getLogado()).orElseGet(ArrayList::new);
                case "municipio":
                    return denuncias.listarMunicipioDenunciante(json.filtro(), logado.getLogado()).orElseGet(ArrayList::new);
                case "categoria":
                    return denuncias.listarCategoriaDenunciante(json.filtro(), logado.getLogado()).orElseGet(ArrayList::new);
                case "data_ocorrencia":
                    Date data = Date.valueOf(json.filtro());
                    return denuncias.listarData_ocorridoDenunciante(data, logado.getLogado()).orElseGet(ArrayList::new);
                case "data_denuncia":
                    Date data2 = Date.valueOf(json.filtro());
                    return denuncias.listarData_denunciaDenunciante(data2, logado.getLogado()).orElseGet(ArrayList::new);
                case "status":
                    System.out.println(json.filtro());
                    return denuncias.listarStatusDenunciante(json.filtro(), logado.getLogado()).orElseGet(ArrayList::new);
            }

        }
        return denuncias.listarProtcoloDenunciante(json.filtro(), logado.getLogado()).orElseGet(ArrayList::new);
    }

    public Denuncia obter(Long id){
        return denuncias.findById(id).orElseGet(Denuncia::new);
    }

    public  Denuncia atualizar(denuncia2json json, Long id){
        Denuncia den = obter(id);
        den.setStatus(json.status());
        den.setParecer_tec(json.parecer_tec());
        return denuncias.save(den);
    }

}
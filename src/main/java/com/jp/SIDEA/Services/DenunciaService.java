package com.jp.SIDEA.Services;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Records.denunciajson;
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
        den.setAtividade(json.atividade());
        den.setCategoria(json.categoria());
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
        den.setStatus("aguardando atendimento");
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

}
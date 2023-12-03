package com.jp.SIDEA.Services;

import com.jp.SIDEA.Models.Anexo;
import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Persistencia.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class AnexoService {
    @Autowired
    private AnexoRepository anexos;

    @Autowired DenunciaService denuncias;


    public Anexo Salvar(MultipartFile imagem, Denuncia den) throws IOException {
        Anexo anex = new Anexo();
        anex.setConteudo(imagem.getBytes());
        anex.setDenuncia_id(den);
        anex.setNome_arquivo(imagem.getOriginalFilename());
        Path path = Paths.get(anex.getNome_arquivo());
        anex.setNomeSemExtensao(path.getFileName().toString().replaceFirst("[.][^.]+$", ""));
        anex.setTipo_arquivo( imagem.getContentType());
        anexos.save(anex);
        return anex;
    }

    public Optional<Anexo> AnexoDaDenuncia(Long id){
        Denuncia den = denuncias.obter(id);
        return anexos.anexosDaDenuncia(den);
    }


}

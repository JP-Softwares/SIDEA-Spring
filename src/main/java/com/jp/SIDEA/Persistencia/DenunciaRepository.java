package com.jp.SIDEA.Persistencia;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    Denuncia findByProtocolo(String protocolo);


    @Query("FROM Denuncia WHERE autor = :autor")
    Optional<List<Denuncia>> listarTodosDoAutor(Usuario autor);

    @Query("FROM Denuncia WHERE autor = :autor or executor = :autor")
    Optional<List<Denuncia>> listarTodosDoUsuario(Usuario autor);

    @Query("FROM Denuncia")
    Optional<List<Denuncia>> listarTodos();


    @Query("FROM Denuncia WHERE protocolo = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarProtcoloDenunciante(String filtro, Usuario logado);

    @Query("FROM Denuncia WHERE municipio = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarMunicipioDenunciante(String filtro, Usuario logado);

    @Query("FROM Denuncia WHERE categoria = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarCategoriaDenunciante(String filtro, Usuario logado);

    @Query("FROM Denuncia WHERE data_ocorrido = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarData_ocorridoDenunciante(Date filtro, Usuario logado);

    @Query("FROM Denuncia WHERE data_denuncia = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarData_denunciaDenunciante(Date filtro, Usuario logado);

    @Query("FROM Denuncia WHERE status = :filtro and autor = :logado")
    Optional<List<Denuncia>> listarStatusDenunciante(String filtro, Usuario logado);




    @Query("FROM Denuncia WHERE protocolo = :filtro")
    Optional<List<Denuncia>> listarProtcoloAnalista(String filtro);

    @Query("FROM Denuncia WHERE municipio = :filtro")
    Optional<List<Denuncia>> listarMunicipioAnalista(String filtro);

    @Query("FROM Denuncia WHERE categoria = :filtro")
    Optional<List<Denuncia>> listarCategoriaAnalista(String filtro);

    @Query("FROM Denuncia WHERE data_ocorrido = :filtro")
    Optional<List<Denuncia>> listarData_ocorridoAnalista(Date filtro);

    @Query("FROM Denuncia WHERE data_denuncia = :filtro")
    Optional<List<Denuncia>> listarData_denunciaAnalista(Date filtro);

    @Query("FROM Denuncia WHERE status = :filtro")
    Optional<List<Denuncia>> listarStatusAnalista(String filtro);


}

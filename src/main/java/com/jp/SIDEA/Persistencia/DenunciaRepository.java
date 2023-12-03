package com.jp.SIDEA.Persistencia;


import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

    @Query("FROM Denuncia WHERE status = 'aguardando atendimento' ")
    Optional<List<Denuncia>> listarAbertas();

    @Query("FROM Denuncia WHERE protocolo like :protocolo and municipio like :municipio and categoria like :categoria and status like :status")
    Optional<List<Denuncia>> listarFiltradasTotal(String protocolo, String municipio, String categoria, String status);

}

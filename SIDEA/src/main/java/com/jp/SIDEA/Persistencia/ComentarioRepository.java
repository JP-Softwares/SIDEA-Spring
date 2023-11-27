package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
    Comentario findByProtocolo(String id);
}

package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Comentario;
import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    Telefone findByProtocolo(String id);
}

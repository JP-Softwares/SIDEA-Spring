package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Anexo;
import com.jp.SIDEA.Models.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    Anexo findByProtocolo(String id);
}

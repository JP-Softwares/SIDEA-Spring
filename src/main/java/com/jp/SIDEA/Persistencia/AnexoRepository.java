package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Anexo;
import com.jp.SIDEA.Models.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    Anexo findByid(Long id);

    @Query("FROM Anexo WHERE denuncia_id = :den")
    Optional<Anexo> anexosDaDenuncia(Denuncia den);
}

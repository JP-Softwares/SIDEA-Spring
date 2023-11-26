package com.jp.SIDEA.Persistencia;


import com.jp.SIDEA.Models.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    Denuncia findByProtocolo(String protocolo);

}

package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByid(Long id);
}

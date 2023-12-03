package com.jp.SIDEA.Persistencia;

import com.jp.SIDEA.Models.Denuncia;
import com.jp.SIDEA.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);

    @Query("FROM Usuario ")
    Optional<List<Usuario>> listarTodos();
}

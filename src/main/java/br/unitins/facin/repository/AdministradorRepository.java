package br.unitins.facin.repository;

import br.unitins.facin.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);
}

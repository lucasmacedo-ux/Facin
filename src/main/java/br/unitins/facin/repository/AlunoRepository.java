package br.unitins.facin.repository;

import br.unitins.facin.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    List<Aluno> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}

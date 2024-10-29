package br.com.etechoracio.pw_study.repository;

import br.com.etechoracio.pw_study.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByNome(String nome);
}

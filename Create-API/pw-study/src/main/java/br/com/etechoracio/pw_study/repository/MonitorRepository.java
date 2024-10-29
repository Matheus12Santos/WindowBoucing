package br.com.etechoracio.pw_study.repository;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Optional<Monitor> findByDisciplina(Disciplina idDisciplina);

    Optional<Monitor> findByWhatsappAndEmail(String whatsapp, String email);
}

package br.com.etechoracio.pw_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONEXAO")
    private Long idConexao;

    @Column(name = "DT_CRIACAO")
    private LocalDate dtCriacao;

    @ManyToMany
    @JoinColumn(name = "ID_MONITOR")
    private Monitor idMonitor;
}

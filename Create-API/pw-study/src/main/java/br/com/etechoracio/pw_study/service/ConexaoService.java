package br.com.etechoracio.pw_study.service;

import br.com.etechoracio.pw_study.repository.ConexaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexaoService {
    @Autowired
    private ConexaoRepository repository;

    public Long contar(){
        return repository.count();
    }
}

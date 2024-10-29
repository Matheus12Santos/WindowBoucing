package br.com.etechoracio.pw_study.service;

import br.com.etechoracio.pw_study.entity.Monitor;
import br.com.etechoracio.pw_study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository repository;

    public List<Monitor> listar(){
        return repository.findAll();
    }

    public Monitor cadastrar(Monitor monitor){
        var existe = repository.findByWhatsappAndEmail(monitor.getWhatsapp(), monitor.getEmail());
        if(!existe.isEmpty()){
            throw new RuntimeException("Telefone ou Email já cadastrados.");
        }
        return repository.save(monitor);
    }
}

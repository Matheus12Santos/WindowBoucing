package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.entity.Monitor;
import br.com.etechoracio.pw_study.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitores")
public class MonitorController {
    @Autowired
    private MonitorService service;

    @GetMapping
    public List<Monitor> listar(){
        return service.listar();
    }

    public Monitor cadastrar(@RequestBody Monitor monitor){
        return service.cadastrar(monitor);
    }
}

package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.service.ConexaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conexoes")
public class ConexaoController {
    @Autowired
    private ConexaoService service;

    @GetMapping
    public Long quantConexoes(){
        return service.contar();
    }
}

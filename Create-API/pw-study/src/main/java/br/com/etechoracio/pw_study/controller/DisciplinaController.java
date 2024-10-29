package br.com.etechoracio.pw_study.controller;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.service.DisciplinaService;
import org.hibernate.sql.results.graph.entity.internal.DiscriminatedEntityInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService service;

    // Criar um metodo que retornara uma lista de disciplina
    @GetMapping
    public List<Disciplina> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id){
        var existe = service.buscarPorId(id);
        if(existe.isPresent()){                                  // if(!existe.isEmpty)
            return ResponseEntity.ok(existe.get());
        }else{
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);   Os 2 returns sao iguais
            return ResponseEntity.notFound().build();
        } // De cima é a mesma coisa que o de baixo
        // return service.buscarPorId(id).map(e -> ResponseEntity.ok(e)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina){
        return service.cadastrar(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> deletarId(@PathVariable Long id){
        var existe = service.buscarPorId(id);
        if (existe.isPresent()) {
            service.excluir(existe.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        var existe = service.buscarPorId(id);
        if(existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var atualizado = service.atualizar(disciplina);
        return ResponseEntity.ok(atualizado);
    }
}

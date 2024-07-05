package com.example.demo.controller;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    public TesteRepository repository;

    @GetMapping("/todos")
    public List<Teste> getAllTeste() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Teste getTesteById(@PathVariable Long id) {
        Optional<Teste> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteTeste(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Teste createTeste(@RequestBody Teste teste) {
        return repository.save(teste);
    }

    @PutMapping
    public Teste updateTeste(@RequestBody Teste teste) {
        return repository.save(teste);
    }
}

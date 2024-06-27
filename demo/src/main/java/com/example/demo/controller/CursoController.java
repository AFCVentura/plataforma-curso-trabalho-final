package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    public CursoRepository repository;

    @GetMapping("/todos")
    public List<Curso> getAllCursos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id){
        Optional<Curso> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteCurso(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @PutMapping
    public Curso updateCurso(@RequestBody Curso curso) {
        return repository.save(curso);
    }
}
package org.example.trabalhofinal.controller;

import org.example.trabalhofinal.repository.*;
import org.example.trabalhofinal.model.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    public ComentarioRepository repository;

    @GetMapping("/todos")
    public List<Comentario> getAllComentarios() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Comentario getComentarioById(@PathVariable Long id) {
        Optional<Comentario> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteComentario(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return repository.save(comentario);
    }

    @PutMapping
    public Comentario updateComentario(@RequestBody Comentario comentario) {
        return repository.save(comentario);
    }
}

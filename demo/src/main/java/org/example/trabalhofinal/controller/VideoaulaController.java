package org.example.trabalhofinal.controller;

import org.example.trabalhofinal.repository.*;
import org.example.trabalhofinal.model.Videoaula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videoaula")
public class VideoaulaController {

    @Autowired
    public VideoaulaRepository repository;

    @GetMapping("/todos")
    public List<Videoaula> getAllVideoaula() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Videoaula getVideoaulaById(@PathVariable Long id) {
        Optional<Videoaula> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deleteVideoaula(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Videoaula createVideoaula(@RequestBody Videoaula videoaula) {
        return repository.save(videoaula);
    }

    @PutMapping
    public Videoaula updateVideoaula(@RequestBody Videoaula videoaula) {
        return repository.save(videoaula);
    }
}

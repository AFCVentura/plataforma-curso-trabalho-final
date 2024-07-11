package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CursoPostCommand implements CursoCommand {

    private CursoRepository repository;
    private Curso curso;

    @Override
    public Curso execute() {
        return repository.save(curso);
    }

    public CursoPostCommand(CursoRepository repository, Curso curso) {
        this.repository = repository;
        this.curso = curso;
    }
}

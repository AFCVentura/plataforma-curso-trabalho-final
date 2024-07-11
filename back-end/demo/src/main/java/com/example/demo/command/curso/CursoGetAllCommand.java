package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CursoGetAllCommand implements CursoCommand {

    private CursoRepository repository;
    @Override
    public List<Curso> execute() {
        return repository.findAll();
    }

    public CursoGetAllCommand(CursoRepository repository) {
        this.repository = repository;
    }
}

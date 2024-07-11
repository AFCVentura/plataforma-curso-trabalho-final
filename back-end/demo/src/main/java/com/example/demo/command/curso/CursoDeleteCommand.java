package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CursoDeleteCommand implements CursoCommand {
    private CursoRepository repository;
    private Long id;

    @Override
    public Object execute() {
        repository.deleteById(id);
        return null;
    }


    public CursoDeleteCommand(CursoRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

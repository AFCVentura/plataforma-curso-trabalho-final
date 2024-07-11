package com.example.demo.command.teste;

import com.example.demo.command.curso.CursoCommand;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TesteDeleteCommand implements CursoCommand {
    private TesteRepository repository;
    private Long id;

    @Override
    public Object execute() {
        repository.deleteById(id);
        return null;
    }

    public TesteDeleteCommand(TesteRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

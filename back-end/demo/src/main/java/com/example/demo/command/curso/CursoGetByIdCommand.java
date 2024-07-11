package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
@RequiredArgsConstructor
public class CursoGetByIdCommand implements CursoCommand {

    private CursoRepository repository;
    private Long id;

    @Override
    public Curso execute() {
        Optional<Curso> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    public CursoGetByIdCommand(CursoRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

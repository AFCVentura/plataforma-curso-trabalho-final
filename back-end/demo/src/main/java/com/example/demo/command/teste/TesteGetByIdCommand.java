package com.example.demo.command.teste;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TesteGetByIdCommand implements TesteCommand {
    private TesteRepository repository;
    private Long id;

    @Override
    public Teste execute() {
        Optional<Teste> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }


    public TesteGetByIdCommand(TesteRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

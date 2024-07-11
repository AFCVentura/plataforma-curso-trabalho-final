package com.example.demo.command.teste;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestePostCommand implements TesteCommand {

    private TesteRepository repository;
    private Teste teste;

    @Override
    public Teste execute() {
        return repository.save(teste);
    }

    public TestePostCommand(TesteRepository repository, Teste teste) {
        this.repository = repository;
        this.teste = teste;
    }
}

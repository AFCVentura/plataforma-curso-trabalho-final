package com.example.demo.command.teste;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TesteGetAllCommand implements TesteCommand {
    private TesteRepository repository;

    @Override
    public List<Teste> execute() {
        return repository.findAll();
    }

    public TesteGetAllCommand(TesteRepository repository) {
        this.repository = repository;
    }
}

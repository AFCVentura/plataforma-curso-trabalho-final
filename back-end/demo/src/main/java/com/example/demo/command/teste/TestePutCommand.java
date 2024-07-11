package com.example.demo.command.teste;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestePutCommand implements TesteCommand {

    private TesteRepository repository;
    private Long id;
    private Teste teste;

    @Override
    public Teste execute() {
        return repository.findById(id)
                .map(putTeste -> {
                    putTeste.setDescricao(teste.getDescricao());
                    putTeste.setCurso(teste.getCurso());
                    return repository.save(putTeste);
                })
                .orElseGet(() -> {
                    return repository.save(teste);
                });
    }

    public TestePutCommand(TesteRepository repository, Long id, Teste teste) {
        this.repository = repository;
        this.id = id;
        this.teste = teste;
    }
}

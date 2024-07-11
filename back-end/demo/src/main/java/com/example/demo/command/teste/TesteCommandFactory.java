package com.example.demo.command.teste;

import com.example.demo.model.Teste;
import com.example.demo.repository.TesteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.demo.command.teste.TesteCommand.*;

@Component
@RequiredArgsConstructor
public class TesteCommandFactory {
    private final TesteRepository repository;

    public TesteCommand create(int codigoCommand, Object... params) {
        switch (codigoCommand) {
            case POST:
                new TestePostCommand(repository, (Teste)params[0]);
            case GETALL:
                new TesteGetAllCommand(repository);
            case GETBYID:
                new TesteGetByIdCommand(repository, (Long)params[0]);
            case PUT:
                new TestePutCommand(repository, (Long)params[0], (Teste)params[1]);
            case DELETE:
                new TesteDeleteCommand(repository, (Long)params[0]);
            default:
                return null;
        }
    }
}

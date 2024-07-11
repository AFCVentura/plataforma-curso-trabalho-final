package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo.command.curso.CursoCommand.*;

@Component
@RequiredArgsConstructor
public class CursoCommandFactory {
    private final CursoRepository repository;

    public CursoCommand create(int codigoCommand, Object... params) {
        switch (codigoCommand){
            case POST:
                return new CursoPostCommand(repository, (Curso)params[0]);
            case GETALL:
                return new CursoGetAllCommand(repository);
            case GETBYID:
                return new CursoGetByIdCommand(repository, (Long)params[0]);
            case PUT:
                return new CursoPutCommand(repository, (Long)params[0], (Curso)params[1]);
            case DELETE:
                return new CursoDeleteCommand(repository, (Long)params[0]);
            default:
                return null;
        }
    }
}

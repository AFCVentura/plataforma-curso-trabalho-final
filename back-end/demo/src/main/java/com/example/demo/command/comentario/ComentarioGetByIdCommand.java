package com.example.demo.command.comentario;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@RequiredArgsConstructor
public class ComentarioGetByIdCommand implements ComentarioCommand {

    private ComentarioRepository repository;
    private Long id;

    @Override
    public Comentario execute() {
        Optional<Comentario> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }


    public ComentarioGetByIdCommand(ComentarioRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

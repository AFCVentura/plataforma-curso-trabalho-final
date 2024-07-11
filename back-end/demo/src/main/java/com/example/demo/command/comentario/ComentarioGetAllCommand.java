package com.example.demo.command.comentario;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RequiredArgsConstructor
public class ComentarioGetAllCommand implements ComentarioCommand {

    private ComentarioRepository repository;

    @Override
    public List<Comentario> execute() {
        return repository.findAll();
    }

    public ComentarioGetAllCommand(ComentarioRepository repository) {
        this.repository = repository;
    }
}

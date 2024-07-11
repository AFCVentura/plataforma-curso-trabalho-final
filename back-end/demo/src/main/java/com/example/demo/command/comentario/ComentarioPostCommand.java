package com.example.demo.command.comentario;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@RequiredArgsConstructor
public class ComentarioPostCommand implements ComentarioCommand {

    private ComentarioRepository repository;
    private Comentario comentario;
    @Override
    public Comentario execute() {
        return repository.save(comentario);
    }

    public ComentarioPostCommand(ComentarioRepository repository, Comentario comentario) {
        this.repository = repository;
        this.comentario = comentario;
    }
}

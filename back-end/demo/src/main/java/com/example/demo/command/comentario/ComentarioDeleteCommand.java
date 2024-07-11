package com.example.demo.command.comentario;

import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ComentarioDeleteCommand implements ComentarioCommand {
    private ComentarioRepository repository;
    private Long id;

    @Override
    public Object execute() {
        repository.deleteById(id);
        return null;
    }

    public ComentarioDeleteCommand(ComentarioRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

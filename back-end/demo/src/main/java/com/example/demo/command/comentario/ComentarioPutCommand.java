package com.example.demo.command.comentario;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ComentarioPutCommand implements ComentarioCommand{
    private Long id;
    private ComentarioRepository repository;
    private Comentario comentario;
    @Override
    public Comentario execute() {
        return repository.findById(id)
                .map(putComentario -> {
                    putComentario.setTitulo(comentario.getTitulo());
                    putComentario.setTexto(comentario.getTexto());
                    putComentario.setTimestamp(comentario.getTimestamp());
                    putComentario.setForum(comentario.getForum());
                    putComentario.setUsuario(comentario.getUsuario());
                    return repository.save(putComentario);
                })
                .orElseGet(() -> {
                    return repository.save(comentario);
                });
    }

    public ComentarioPutCommand(ComentarioRepository repository, Long id, Comentario comentario) {
        this.id = id;
        this.repository = repository;
        this.comentario = comentario;
    }
}

package com.example.demo.command.comentario;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo.command.comentario.ComentarioCommand.*;

@Component
@RequiredArgsConstructor
public class ComentarioCommandFactory {

    private final ComentarioRepository comentarioRepository;

    public ComentarioCommand create(int codigoCommand, Object... params) {
        switch (codigoCommand){
            case POST:
                return new ComentarioPostCommand(comentarioRepository, (Comentario)params[0]);
            case GETALL:
                return new ComentarioGetAllCommand(comentarioRepository);
            case GETBYID:
                return new ComentarioGetByIdCommand(comentarioRepository, (Long)params[0]);
            case PUT:
                return new ComentarioPutCommand(comentarioRepository, (Long)params[0], (Comentario)params[1]);
            case DELETE:
                return new ComentarioDeleteCommand(comentarioRepository, (Long)params[0]);
            default:
                return null;
        }
    }
}

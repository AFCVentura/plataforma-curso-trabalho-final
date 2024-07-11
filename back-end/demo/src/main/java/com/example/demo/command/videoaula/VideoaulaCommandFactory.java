package com.example.demo.command.videoaula;

import com.example.demo.model.Videoaula;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.demo.command.videoaula.VideoaulaCommand.*;

@Component
@RequiredArgsConstructor
public class VideoaulaCommandFactory {
    private final VideoaulaRepository repository;

    public VideoaulaCommand create(int codigoCommand, Object... params) {
        switch (codigoCommand) {
            case POST:
                new VideoaulaPostCommand(repository, (Videoaula)params[0]);
            case GETALL:
                new VideoaulaGetAllCommand(repository);
            case GETBYID:
                new VideoaulaGetByIdCommand(repository, (Long)params[0]);
            case PUT:
                new VideoaulaPutCommand(repository, (Long)params[0], (Videoaula)params[1]);
            case DELETE:
                new VideoaulaDeleteCommand(repository, (Long)params[0]);
            default:
                return null;
        }
    }
}

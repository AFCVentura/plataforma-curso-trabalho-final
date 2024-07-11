package com.example.demo.command.forum;

import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.command.forum.ForumCommand.*;

@Component
@RequiredArgsConstructor
public class ForumCommandFactory {
    private final ForumRepository repository;

    public ForumCommand create(int codigoCommand, Object... params) {
        switch (codigoCommand) {
            case POST:
                new ForumPostCommand(repository, (Forum)params[0]);
            case GETALL:
                new ForumGetAllCommand(repository);
            case GETBYID:
                new ForumGetByIdCommand(repository, (Long)params[0]);
            case PUT:
                new ForumPutCommand(repository, (Long)params[0], (Forum)params[1]);
            case DELETE:
                new ForumDeleteCommand(repository, (Long)params[0]);
            default:
                return null;
        }
    }
}

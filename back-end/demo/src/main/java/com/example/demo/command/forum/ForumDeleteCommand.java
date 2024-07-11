package com.example.demo.command.forum;

import com.example.demo.command.curso.CursoCommand;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ForumDeleteCommand implements CursoCommand {
    private ForumRepository repository;
    private Long id;

    @Override
    public Object execute() {
        repository.deleteById(id);
        return null;
    }

    public ForumDeleteCommand(ForumRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

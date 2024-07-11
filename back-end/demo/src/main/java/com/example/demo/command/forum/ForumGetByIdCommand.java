package com.example.demo.command.forum;

import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ForumGetByIdCommand implements ForumCommand{
    private ForumRepository repository;
    private Long id;

    @Override
    public Forum execute() {
        Optional<Forum> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }


    public ForumGetByIdCommand(ForumRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

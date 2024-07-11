package com.example.demo.command.forum;

import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ForumGetAllCommand implements ForumCommand{
    private ForumRepository repository;

    @Override
    public List<Forum> execute() {
        return repository.findAll();
    }

    public ForumGetAllCommand(ForumRepository repository) {
        this.repository = repository;
    }
}

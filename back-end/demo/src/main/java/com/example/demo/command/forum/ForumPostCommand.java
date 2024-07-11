package com.example.demo.command.forum;

import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ForumPostCommand implements ForumCommand{

    private ForumRepository repository;
    private Forum forum;

    @Override
    public Forum execute() {
        return repository.save(forum);
    }

    public ForumPostCommand(ForumRepository repository, Forum forum) {
        this.repository = repository;
        this.forum = forum;
    }
}

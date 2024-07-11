package com.example.demo.command.forum;

import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ForumPutCommand implements ForumCommand{

    private ForumRepository repository;
    private Long id;
    private Forum forum;

    @Override
    public Forum execute() {
        return repository.findById(id)
                .map(putForum -> {
                    putForum.setNome(forum.getNome());
                    putForum.setDescricao(forum.getAssunto());
                    putForum.setAssunto(forum.getAssunto());
                    putForum.setComentarios(forum.getComentarios());
                    putForum.setCurso(forum.getCurso());
                    return repository.save(putForum);
                })
                .orElseGet(() -> {
                    return repository.save(forum);
                });
    }

    public ForumPutCommand(ForumRepository repository, Long id, Forum forum) {
        this.repository = repository;
        this.id = id;
        this.forum = forum;
    }
}

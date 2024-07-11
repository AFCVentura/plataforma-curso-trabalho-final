package com.example.demo.command.videoaula;

import com.example.demo.model.Videoaula;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoaulaPutCommand implements VideoaulaCommand {

    private VideoaulaRepository repository;
    private Long id;
    private Videoaula videoaula;

    @Override
    public Videoaula execute() {
        return repository.findById(id)
                .map(putVideoaula -> {
                    putVideoaula.setUrl(videoaula.getUrl());
                    putVideoaula.setCurso(videoaula.getCurso());
                    return repository.save(putVideoaula);
                })
                .orElseGet(() -> {
                    return repository.save(videoaula);
                });
    }

    public VideoaulaPutCommand(VideoaulaRepository repository, Long id, Videoaula videoaula) {
        this.repository = repository;
        this.id = id;
        this.videoaula = videoaula;
    }
}

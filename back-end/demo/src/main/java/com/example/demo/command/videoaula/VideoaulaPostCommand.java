package com.example.demo.command.videoaula;

import com.example.demo.model.Videoaula;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoaulaPostCommand implements VideoaulaCommand {

    private VideoaulaRepository repository;
    private Videoaula videoaula;

    @Override
    public Videoaula execute() {
        return repository.save(videoaula);
    }

    public VideoaulaPostCommand(VideoaulaRepository repository, Videoaula videoaula) {
        this.repository = repository;
        this.videoaula = videoaula;
    }
}

package com.example.demo.command.videoaula;

import com.example.demo.model.Videoaula;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VideoaulaGetAllCommand implements VideoaulaCommand {
    private VideoaulaRepository repository;

    @Override
    public List<Videoaula> execute() {
        return repository.findAll();
    }

    public VideoaulaGetAllCommand(VideoaulaRepository repository) {
        this.repository = repository;
    }
}

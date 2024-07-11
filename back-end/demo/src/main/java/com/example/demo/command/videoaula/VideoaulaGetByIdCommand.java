package com.example.demo.command.videoaula;

import com.example.demo.model.Videoaula;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class VideoaulaGetByIdCommand implements VideoaulaCommand {
    private VideoaulaRepository repository;
    private Long id;

    @Override
    public Videoaula execute() {
        Optional<Videoaula> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }


    public VideoaulaGetByIdCommand(VideoaulaRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

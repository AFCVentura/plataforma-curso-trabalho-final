package com.example.demo.command.videoaula;

import com.example.demo.command.curso.CursoCommand;
import com.example.demo.repository.VideoaulaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoaulaDeleteCommand implements CursoCommand {
    private VideoaulaRepository repository;
    private Long id;

    @Override
    public Object execute() {
        repository.deleteById(id);
        return null;
    }

    public VideoaulaDeleteCommand(VideoaulaRepository repository, Long id) {
        this.repository = repository;
        this.id = id;
    }
}

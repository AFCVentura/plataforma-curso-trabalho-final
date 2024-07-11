package com.example.demo.command.curso;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CursoPutCommand implements CursoCommand{

    private CursoRepository repository;
    private Long id;

    private Curso curso;


    @Override
    public Curso execute() {
        return repository.findById(id)
                .map(putCurso -> {
                    putCurso.setNome(curso.getNome());
                    putCurso.setAssunto(curso.getAssunto());
                    putCurso.setTema(curso.getTema());
                    putCurso.setVideoaulas(curso.getVideoaulas());
                    putCurso.setForum(curso.getForum());
                    putCurso.setUsers(curso.getUsers());
                    return repository.save(putCurso);
                })
                .orElseGet(() -> {
                    return repository.save(curso);
                });
    }

    public CursoPutCommand(CursoRepository repository, Long id, Curso curso) {
        this.repository = repository;
        this.id = id;
        this.curso = curso;
    }
}

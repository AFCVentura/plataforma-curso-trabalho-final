package com.example.demo.controller;


import com.example.demo.command.curso.CursoCommand;
import com.example.demo.command.curso.CursoCommandFactory;
import com.example.demo.model.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    CursoCommandFactory cursoCommandFactory;

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return
                (Curso)cursoCommandFactory
                        .create(CursoCommand.POST, curso)
                        .execute();
    }

    @GetMapping("/todos")
    public List<Curso> getAllCursos() {
        return
                (List<Curso>)cursoCommandFactory
                        .create(CursoCommand.GETALL)
                        .execute();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return
                (Curso)cursoCommandFactory
                        .create(CursoCommand.GETBYID)
                        .execute();
    }

    @PutMapping
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return
                (Curso)cursoCommandFactory
                        .create(CursoCommand.PUT, id, curso)
                        .execute();

    }

    @DeleteMapping
    public Curso deleteCurso(@PathVariable Long id) {
        return
                (Curso) cursoCommandFactory
                        .create(CursoCommand.DELETE, id)
                        .execute();
    }




}
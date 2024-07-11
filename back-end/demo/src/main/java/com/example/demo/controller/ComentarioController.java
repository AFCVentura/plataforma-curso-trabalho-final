package com.example.demo.controller;

import com.example.demo.command.comentario.ComentarioCommandFactory;
import com.example.demo.model.Comentario;
import com.example.demo.command.comentario.ComentarioCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    ComentarioCommandFactory comentarioCommandFactory;

    @PostMapping
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return
                (Comentario)comentarioCommandFactory
                        .create(ComentarioCommand.POST,comentario)
                        .execute();
    }

    @GetMapping("/todos")
    public List<Comentario> getAllComentarios() {
        return
                (List<Comentario>)comentarioCommandFactory
                        .create(ComentarioCommand.GETALL)
                        .execute();
    }

    @GetMapping("/{id}")
    public Comentario getComentarioById(@PathVariable Long id) {
        return
                (Comentario)comentarioCommandFactory
                        .create(ComentarioCommand.GETBYID, id)
                        .execute();
    }

    @PutMapping("/{id}")
    public Comentario updateComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        return
                (Comentario) comentarioCommandFactory
                        .create(ComentarioCommand.PUT, id, comentario)
                        .execute();
    }

    @DeleteMapping("/{id}")
    public Comentario deleteComentario(@PathVariable Long id) {
        return
                (Comentario)comentarioCommandFactory
                        .create(ComentarioCommand.DELETE, id)
                        .execute();
    }




}

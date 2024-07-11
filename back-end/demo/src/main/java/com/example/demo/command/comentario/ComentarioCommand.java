package com.example.demo.command.comentario;

import com.example.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ComentarioCommand {
    int POST = 1;
    int GETALL = 2;
    int GETBYID = 3;
    int PUT = 4;
    int DELETE = 5;


    Object execute();
}

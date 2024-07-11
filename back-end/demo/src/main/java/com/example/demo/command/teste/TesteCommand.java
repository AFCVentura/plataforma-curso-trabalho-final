package com.example.demo.command.teste;

public interface TesteCommand {
    int POST = 1;
    int GETALL = 2;
    int GETBYID = 3;
    int PUT = 4;
    int DELETE = 5;

    Object execute();
}

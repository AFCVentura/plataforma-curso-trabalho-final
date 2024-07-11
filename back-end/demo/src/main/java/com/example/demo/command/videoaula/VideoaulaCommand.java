package com.example.demo.command.videoaula;

public interface VideoaulaCommand {
    int POST = 1;
    int GETALL = 2;
    int GETBYID = 3;
    int PUT = 4;
    int DELETE = 5;

    Object execute();
}

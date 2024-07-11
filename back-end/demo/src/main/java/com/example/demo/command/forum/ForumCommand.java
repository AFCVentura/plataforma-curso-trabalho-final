package com.example.demo.command.forum;

public interface ForumCommand {
    int POST = 1;
    int GETALL = 2;
    int GETBYID = 3;
    int PUT = 4;
    int DELETE = 5;

    Object execute();
}

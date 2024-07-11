package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.command.forum.ForumCommand;
import com.example.demo.command.forum.ForumCommandFactory;
import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forum")
public class ForumController {

    ForumCommandFactory forumCommandFactory;


    @PostMapping
    public Forum createForum(@RequestBody Forum forum) {
        return
                (Forum)forumCommandFactory
                        .create(ForumCommand.POST, forum)
                        .execute();
    }

    @GetMapping("/todos")
    public List<Forum> getAllForum() {
        return
                (List<Forum>)forumCommandFactory
                        .create(ForumCommand.GETALL)
                        .execute();
    }

    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable Long id) {
       return
               (Forum)forumCommandFactory
                       .create(ForumCommand.GETBYID, id)
                       .execute();
    }

    @PutMapping
    public Forum updateForum(@PathVariable Long id, @RequestBody Forum forum) {
        return
                (Forum)forumCommandFactory
                        .create(ForumCommand.PUT, id, forum)
                        .execute();
    }

    @DeleteMapping
    public Forum deleteForum(@PathVariable Long id) {
        return
                (Forum)forumCommandFactory
                        .create(ForumCommand.DELETE, id)
                        .execute();
    }



}

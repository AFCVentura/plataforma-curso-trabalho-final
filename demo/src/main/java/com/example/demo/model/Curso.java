package com.example.demo.model;

import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String assunto;

    private String tema;

    @ManyToMany
    private List<User> usuarios;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Videoaula> videoaulas;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Forum> forum;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Teste> testes;

    public Curso(String nome, String assunto, String tema, User professor, List<User> alunos, List<Forum> forum, List<Videoaula> videoaulas, List<Teste> testes) {
        this.nome = nome;
        this.assunto = assunto;
        this.tema = tema;
        this.professor = professor;
        this.alunos = alunos;
        this.forum = forum;
        this.videoaulas = videoaulas;
        this.testes = testes;
    }

    public Curso() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }

    public List<User> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<User> alunos) {
        this.alunos = alunos;
    }

    public List<Teste> getTestes() {
        return testes;
    }

    public void setTestes(List<Teste> testes) {
        this.testes = testes;
    }

    public List<Videoaula> getVideoaulas() {
        return videoaulas;
    }

    public void setVideoaulas(List<Videoaula> videoaulas) {
        this.videoaulas = videoaulas;
    }

    public List<Forum> getForum() {
        return forum;
    }

    public void setForum(List<Forum> forum) {
        this.forum = forum;
    }

}

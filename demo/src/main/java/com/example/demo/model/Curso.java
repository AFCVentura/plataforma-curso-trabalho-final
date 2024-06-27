package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;

    private String dataValidade;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Videoaula> videoAulas;

    public Curso(String titulo, String descricao, String dataValidade, List<Videoaula> videoAulas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.videoAulas = videoAulas;
    }

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}

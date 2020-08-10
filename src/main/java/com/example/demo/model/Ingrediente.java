package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingrediente")
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    //@NotNull
    @Column(name = "descricao")
    private String descricao;


    @JsonBackReference
    @ManyToMany(mappedBy = "ingredientes", fetch = FetchType.LAZY)
    private List<Doce> doces = new ArrayList<>();


    public Ingrediente() {
    }




    public List<Doce> getDoces() {
        return doces;
    }

    public void setDoces(List<Doce> doces) {
        this.doces = doces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

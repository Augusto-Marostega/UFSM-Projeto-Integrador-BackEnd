package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doce")
public class Doce implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;


    @NotNull
    @Column(name = "peso", nullable = false)
    private String peso;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "foto", nullable = false)
    private String foto;

    @NotNull
    @Column(name = "preco", columnDefinition = "DECIMAL(6,2)")
    private BigDecimal preco;

    //@JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doce_ingrediente",
            joinColumns = @JoinColumn(name = "doce_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "doce", fetch = FetchType.LAZY)
    private List<Encomenda_Doce> encomenda_doces = new ArrayList<>();


    public Doce() {
    }

    public List<Encomenda_Doce> getEncomenda_doces() {
        return encomenda_doces;
    }

    public void setEncomenda_doces(List<Encomenda_Doce> encomenda_doces) {
        this.encomenda_doces = encomenda_doces;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}

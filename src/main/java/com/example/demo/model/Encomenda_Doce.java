package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "encomenda_doce")
public class Encomenda_Doce implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "quantidade", nullable = false)
    private String quantidade;

    @NotNull
    @Column(name = "preco_un", columnDefinition = "DECIMAL(6,2)")
    private BigDecimal preco_un;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Encomenda.class)
    @JoinColumn(name = "encomenda_id", nullable = false)
    private Encomenda encomenda;

    @ManyToOne
    @JoinColumn(name = "doce_id")
    private Doce doce;

    public Encomenda_Doce() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco_un() {
        return preco_un;
    }

    public void setPreco_un(BigDecimal preco_un) {
        this.preco_un = preco_un;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Doce getDoce() {
        return doce;
    }

    public void setDoce(Doce doce) {
        this.doce = doce;
    }
}

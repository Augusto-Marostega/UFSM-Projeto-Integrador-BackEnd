package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "encomenda")
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;


    @OneToMany(mappedBy = "encomenda", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Encomenda_Doce> encomenda_doces = new ArrayList<>();

    @OneToMany(mappedBy = "encomenda", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Encomenda_Estado> encomenda_estados = new ArrayList<>();

    public Encomenda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Encomenda_Doce> getEncomenda_doces() {
        return encomenda_doces;
    }

    public void setEncomenda_doces(List<Encomenda_Doce> encomenda_doces) {
        this.encomenda_doces = encomenda_doces;
    }

    public void addEncomenda_doces(Encomenda_Doce encomenda_doce){
        encomenda_doces.add(encomenda_doce);
        encomenda_doce.setEncomenda(this);
    }

    public void removeEncomenda_doces(Encomenda_Doce encomenda_doce){
         encomenda_doces.remove(encomenda_doce);
         encomenda_doce.setEncomenda(null);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Encomenda_Estado> getEncomenda_estados() {
        return encomenda_estados;
    }

    public void setEncomenda_estados(List<Encomenda_Estado> encomenda_estados) {
        this.encomenda_estados = encomenda_estados;
    }

    public void addEncomenda_estados(Encomenda_Estado encomenda_estado){
        encomenda_estados.add(encomenda_estado);
        encomenda_estado.setEncomenda(this);
    }

    public void removeEncomenda_estados(Encomenda_Estado encomenda_estado){
        encomenda_estados.remove(encomenda_estado);
        encomenda_estado.setEncomenda(null);
    }


}

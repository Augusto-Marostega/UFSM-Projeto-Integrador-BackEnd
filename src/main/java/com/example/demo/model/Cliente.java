package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "nomeusuario", nullable = false, unique = true)
    private String nomeUsuario;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    @NotNull
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;


    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long idCli) {
        this.id = idCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeCli) {
        this.nome = nomeCli;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senhaCli) {
        this.senha = senhaCli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

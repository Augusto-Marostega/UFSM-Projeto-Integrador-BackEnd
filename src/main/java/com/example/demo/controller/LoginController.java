package com.example.demo.controller;


import com.example.demo.model.Cliente;
import com.example.demo.model.Funcionario;
import com.example.demo.model.UsuarioLogin;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping("/cliente")
    public Cliente loginCliente(@RequestBody UsuarioLogin usuarioLogin) {

        System.out.println(usuarioLogin.getNomeUsuario() + usuarioLogin.getSenha());
        return clienteRepository.findByNomeUsuarioAndSenha(usuarioLogin.getNomeUsuario(), usuarioLogin.getSenha());
    }

    @PostMapping("/funcionario")
    public Funcionario loginFuncionario(@RequestBody UsuarioLogin usuarioLogin){
        return funcionarioRepository.findByNomeUsuarioAndSenha(usuarioLogin.getNomeUsuario(), usuarioLogin.getSenha());
    }

}

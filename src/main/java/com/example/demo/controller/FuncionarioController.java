package com.example.demo.controller;


import com.example.demo.model.Cliente;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionario(){
        return this.funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId){
        return this.funcionarioRepository.findById(funcionarioId);
    }

    @PostMapping("/cadastrar")
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionario(@PathVariable(value = "id") Long funcionarioId){
        funcionarioRepository.deleteById(funcionarioId);
    }


    @PutMapping("/editar")
    public Funcionario editarFuncionario(@RequestBody Funcionario novoFuncionario) {

        return funcionarioRepository.findById(novoFuncionario.getId()).map(funcionario -> {
                //funcionario.setNome(novoFuncionario.getNome());
                //funcionario.setNomeUsuario(novoFuncionario.getNomeUsuario());
                funcionario.setSenha(novoFuncionario.getSenha());
                return funcionarioRepository.save(funcionario);
        }).orElseGet(() -> {
            return null;
        });
    }

}

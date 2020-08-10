package com.example.demo.controller;



import com.example.demo.model.Cliente;
import com.example.demo.model.Ingrediente;
import com.example.demo.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping("/ingredientes")
    public List<Ingrediente> getAllIngrediente(){
        return this.ingredienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingrediente> getIngredienteById(@PathVariable(value = "id") Long ingredienteId){
        return this.ingredienteRepository.findById(ingredienteId);
    }

    @PostMapping("/cadastrar")
    public Ingrediente salvarIngrediente(@RequestBody Ingrediente ingrediente){
        System.out.println(ingrediente.getDescricao() + ingrediente.getNome() + ingrediente.getId());
        return ingredienteRepository.save(ingrediente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarIngrediente(@PathVariable(value = "id") Long ingredienteId){
        ingredienteRepository.deleteById(ingredienteId);
    }

    @PutMapping("/editar")
    public Ingrediente editarIngrediente(@RequestBody Ingrediente novoIngrediente) {

        return ingredienteRepository.findById(novoIngrediente.getId()).map(ingrediente -> {
            ingrediente.setNome(novoIngrediente.getNome());
            ingrediente.setDescricao(novoIngrediente.getDescricao());
            return ingredienteRepository.save(ingrediente);
        }).orElseGet(() -> {
            return null;
        });
    }

}

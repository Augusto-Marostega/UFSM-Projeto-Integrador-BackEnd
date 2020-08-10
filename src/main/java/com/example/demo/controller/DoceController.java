package com.example.demo.controller;


import com.example.demo.model.Doce;
import com.example.demo.model.Ingrediente;
import com.example.demo.repository.DoceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doce")
public class DoceController {

    @Autowired
    private DoceRepository doceRepository;

    @GetMapping("/doces")
    public List<Doce> getAllDoces(){
        return this.doceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Doce> getDoceeById(@PathVariable(value = "id") Long doceId){
        return this.doceRepository.findById(doceId);
    }

    @PostMapping("/cadastrar")
    public Doce salvarDoce(@RequestBody Doce doce){
        System.out.println(doce.getNome()+ ' '+ doce.getIngredientes().get(0).getDescricao());
        return doceRepository.save(doce);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarDoce(@PathVariable(value = "id") Long doceId){
        doceRepository.deleteById(doceId);
    }

    @PutMapping("/editar")
    public Doce editarDoce(@RequestBody Doce novoDoce) {

        return doceRepository.findById(novoDoce.getId()).map(doce -> {
            doce.setNome(novoDoce.getNome());
            doce.setDescricao(novoDoce.getDescricao());
            doce.setFoto(novoDoce.getFoto());
            doce.setPeso(novoDoce.getPeso());
            doce.setPreco(novoDoce.getPreco());
            doce.setIngredientes((novoDoce.getIngredientes()));
            return doceRepository.save(doce);
        }).orElseGet(() -> {
            return null;
        });

    }
}

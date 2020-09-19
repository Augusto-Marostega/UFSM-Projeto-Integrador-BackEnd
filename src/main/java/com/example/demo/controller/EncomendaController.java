package com.example.demo.controller;


import com.example.demo.model.Doce;
import com.example.demo.model.Encomenda;
import com.example.demo.model.Encomenda_Doce;
import com.example.demo.model.Encomenda_Estado;
import com.example.demo.repository.DoceRepository;
import com.example.demo.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/encomenda")
public class EncomendaController {

    @Autowired
    private EncomendaRepository encomendaRepository;

    @GetMapping("/encomendas")
    public List<Encomenda> getAllEncomendas(){
        return this.encomendaRepository.findAllByOrderByDataDesc();
    }

    @GetMapping("/{id}")
    public Optional<Encomenda> getEncomendaById(@PathVariable(value = "id") Long encomendaId){
        return this.encomendaRepository.findById(encomendaId);
    }

    @PostMapping("/cadastrar")
    public Encomenda salvarEncomenda(@RequestBody Encomenda encomenda){


        Date dataAtual = new Date();

        encomenda.setData(dataAtual);
        for(Encomenda_Doce b : encomenda.getEncomenda_doces()){
            b.setEncomenda(encomenda);
        }
        return encomendaRepository.save(encomenda);
    }


    @DeleteMapping("/deletar/{id}")
    public void deletarEncomenda(@PathVariable(value = "id") Long encomendaId){
        encomendaRepository.deleteById(encomendaId);
    }


    /*
    @PutMapping("/editar")
    public Doce editarEencomenda(@RequestBody Encomenda novaEncomenda) {

        return encomendaRepository.findById(novaEncomenda.getId()).map(encomenda -> {
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
    }*/
}

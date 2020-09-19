package com.example.demo.controller;


import com.example.demo.model.Encomenda;
import com.example.demo.model.Encomenda_Doce;
import com.example.demo.model.Encomenda_Estado;
import com.example.demo.repository.EncomendaEstadoRepository;
import com.example.demo.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/encomendaEstado")
public class EncomendaEstadoController {

    @Autowired
    private EncomendaEstadoRepository encomendaEstadoRepository;

    @PostMapping("/cadastrar")
    public Encomenda_Estado salvarEncomendaEstado(@RequestBody Encomenda_Estado encomendaEstado){

        Date dataAtual = new Date();

        encomendaEstado.setData(dataAtual);

        return encomendaEstadoRepository.save(encomendaEstado);
    }

}

package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> getAllCliente(){
        return this.clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId){
        return this.clienteRepository.findById(clienteId);
    }

    /*
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
            throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId).
                orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado pelo id: " + clienteId));
        return ResponseEntity.ok().body(cliente);
    }
    */

    @PostMapping("/cadastrar")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable(value = "id") Long clienteId){
        clienteRepository.deleteById(clienteId);
    }


    @PutMapping("/editar")
    public Cliente editarCliente(@RequestBody Cliente novoCliente) {

        return clienteRepository.findById(novoCliente.getId()).map(cliente -> {
            cliente.setCpf(novoCliente.getCpf());
            cliente.setNome(novoCliente.getNome());
            cliente.setNomeUsuario(novoCliente.getNomeUsuario());
            cliente.setSenha(novoCliente.getSenha());
            return clienteRepository.save(cliente);
        }).orElseGet(() -> {
            return null;
        });
    }


}

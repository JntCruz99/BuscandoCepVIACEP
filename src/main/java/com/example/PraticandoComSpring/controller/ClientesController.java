package com.example.PraticandoComSpring.controller;

import com.example.PraticandoComSpring.model.Cliente;
import com.example.PraticandoComSpring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }

}

package com.example.PraticandoComSpring.service;

import com.example.PraticandoComSpring.model.Cliente;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
@Service
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}

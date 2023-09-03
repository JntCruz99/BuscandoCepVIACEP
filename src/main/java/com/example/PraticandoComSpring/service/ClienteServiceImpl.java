package com.example.PraticandoComSpring.service;

import com.example.PraticandoComSpring.model.Cliente;
import com.example.PraticandoComSpring.model.ClienteRepository;
import java.lang.Iterable;
import java.util.Optional;

import com.example.PraticandoComSpring.model.Endereco;
import com.example.PraticandoComSpring.model.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco =enderecoRepository.findById(cep).orElseGet(() -> {
           Endereco novoEndereco = viaCepService.consultarCep(cep);
           enderecoRepository.save(novoEndereco);
           return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            inserir(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}

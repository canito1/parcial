package com.example.support.service.impl;

import com.example.support.exception.RecursoNoEncontradoException;
import com.example.support.model.Cliente;
import com.example.support.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id: " + id));
    }

    @Override
    public Cliente crear(Cliente cliente) {
        cliente.setId(contador.getAndIncrement());
        clientes.add(cliente);
        return cliente;
    }
}

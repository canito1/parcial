package com.example.support.service;

import com.example.support.model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodos();
    Cliente obtenerPorId(Long id);
    Cliente crear(Cliente cliente);
}
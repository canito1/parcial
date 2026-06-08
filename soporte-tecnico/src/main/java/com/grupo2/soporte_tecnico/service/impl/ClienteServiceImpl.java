package com.grupo2.soporte_tecnico.service.impl;

import com.grupo2.soporte_tecnico.exception.RecursoNoEncontradoException;
import com.grupo2.soporte_tecnico.model.Cliente;
import com.grupo2.soporte_tecnico.repository.ClienteRepository;
import com.grupo2.soporte_tecnico.service.ClienteService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarTodos() { return clienteRepository.findAll(); }

    @Override
    public Cliente obtenerPorId(@NonNull Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Cliente no encontrado con ID: " + id));
    }

    @Override
    public Cliente crear(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(@NonNull Long id, Cliente datos) {
        Cliente existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setTelefono(datos.getTelefono());
        existente.setEmpresa(datos.getEmpresa());
        return clienteRepository.save(existente);
    }

    @Override
    public void eliminar(@NonNull Long id) {
        if (!clienteRepository.existsById(id))
            throw new RecursoNoEncontradoException("Cliente no encontrado con ID: " + id);
        clienteRepository.deleteById(id);
    }
}

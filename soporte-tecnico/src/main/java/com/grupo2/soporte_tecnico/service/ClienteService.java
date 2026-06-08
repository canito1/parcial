package com.grupo2.soporte_tecnico.service;

import com.grupo2.soporte_tecnico.model.Cliente;
import org.springframework.lang.NonNull;
import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodos();
    Cliente obtenerPorId(@NonNull Long id);
    Cliente crear(Cliente cliente);
    Cliente actualizar(@NonNull Long id, Cliente cliente);
    void eliminar(@NonNull Long id);
}

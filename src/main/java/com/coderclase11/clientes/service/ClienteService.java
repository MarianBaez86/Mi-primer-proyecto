package com.coderclase11.clientes.service;

import com.coderclase11.clientes.model.Cliente;

import java.util.List;

public interface ClienteService {



    Cliente buscarPordni(long dni);
    List<Cliente>buscarTodosLosClientes();

}

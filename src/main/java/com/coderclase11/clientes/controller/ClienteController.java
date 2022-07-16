package com.coderclase11.clientes.controller;

import com.coderclase11.clientes.model.Cliente;
import com.coderclase11.clientes.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes(){
        return clienteService.buscarTodosLosClientes();
    }

    @GetMapping("/{dni}")
    public Cliente buscarPorDni(@PathVariable Long dni){
        return clienteService.buscarPordni(dni);
    }

   }

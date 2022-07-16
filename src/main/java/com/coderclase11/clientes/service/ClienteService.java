package com.coderclase11.clientes.service;

import com.coderclase11.clientes.model.Cliente;
import com.coderclase11.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente buscarPordni(long dni) {
        Cliente cliente =  repository.findById(dni).orElse(null);
        if (cliente == null){
            return new Cliente();
        }
        int edad = getEdadCliente(cliente.getFechaNacimiento());
        cliente.setEdad(edad);
        return cliente;
    }

    public List<Cliente> buscarTodosLosClientes() {
        List<Cliente> clientes = repository.findAll();
        for (Cliente c:clientes){
            int edadCliente = this.getEdadCliente(c.getFechaNacimiento());
            c.setEdad(edadCliente);
        }

        return clientes;
    }

    private int getEdadCliente(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);
        return period.getYears();
    }
}

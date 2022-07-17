package com.coderclase11.clientes.service;

import com.coderclase11.clientes.converter.dto.ClienteDtoAEntityConverter;
import com.coderclase11.clientes.converter.entity.ClienteEntityADtoConverter;
import com.coderclase11.clientes.dto.ClienteDto;
import com.coderclase11.clientes.model.Cliente;
import com.coderclase11.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteEntityADtoConverter converter;
    private final ClienteDtoAEntityConverter converterDto;

    public ClienteService(ClienteRepository repository, ClienteEntityADtoConverter converter, ClienteDtoAEntityConverter converterDto) {
        this.repository = repository;
        this.converter = converter;
        this.converterDto = converterDto;
    }

    public List<ClienteDto> buscarTodosLosClientes() {

        List<Cliente> clientes = repository.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDto clienteDto = this.converter.convert(cliente);
            clientesDto.add(clienteDto);

        }
        return clientesDto;
    }

    // SIN USAR ClienteDto
    /*public List<Cliente> buscarTodosLosClientes() {
        List<Cliente> clientes = repository.findAll();
        for (Cliente c:clientes){
            int edadCliente = this.getEdadCliente(c.getFechaNacimiento());
            c.setEdad(edadCliente);
        }
        return clientes;
    }*/


    public ClienteDto buscarPordni(long dni) {
        Cliente cliente = repository.findById(dni).orElse(null);
        if (cliente == null){
            return new ClienteDto();
        }
        ClienteDto clienteDto = this.converter.convert(cliente);
        return clienteDto;
    }

    // SIN USAR ClienteDto
   /* public Cliente buscarPordni(long dni) {
        Cliente cliente =  repository.findById(dni).orElse(null);
        if (cliente == null){
            return new Cliente();
        }
        int edad = getEdadCliente(cliente.getFechaNacimiento());
        cliente.setEdad(edad);
        return cliente;
    }*/


    public ClienteDto actualizarCliente(ClienteDto clienteDto){
        Cliente cliente = this.converterDto.convert(clienteDto);
        this.repository.save(cliente);
        return clienteDto;
    }


    private int getEdadCliente(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);
        return period.getYears();
    }
}

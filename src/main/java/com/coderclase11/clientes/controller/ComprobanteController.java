package com.coderclase11.clientes.controller;

import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.service.ClienteService;
import com.coderclase11.clientes.service.ComprobanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/comprobante")
public class ComprobanteController {

    private final ComprobanteService comprobanteService;

    public ComprobanteController(ComprobanteService comprobanteService) {
        this.comprobanteService = comprobanteService;
    }

    @GetMapping
    public List<ComprobanteDto> obtenerTodosLosComprobantes(){
        return comprobanteService.listarTodosLosComprobantes();
    }
}

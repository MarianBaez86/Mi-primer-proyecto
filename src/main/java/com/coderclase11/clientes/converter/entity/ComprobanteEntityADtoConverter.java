package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.model.Comprobante;
import org.springframework.stereotype.Component;

@Component
public class ComprobanteEntityADtoConverter {
    public ComprobanteDto convert(Comprobante comprobante) {
        ComprobanteDto comprobanteDto = new ComprobanteDto();
        comprobanteDto.setId(comprobante.getId());
        comprobanteDto.setClienteId(comprobante.getCliente());
        comprobanteDto.setTotal(comprobante.getTotal());
        comprobanteDto.setFecha_creacion(comprobante.getFecha_creacion());
        comprobanteDto.setCuit_empresa(comprobante.getCuit_empresa());
        return comprobanteDto;
    }
}


package com.coderclase11.clientes.converter.dto;

import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.model.Comprobante;
import org.springframework.stereotype.Component;

@Component
public class ComprobanteDtoAEntityConverter {
    public Comprobante convert(ComprobanteDto comprobateDto){
        Comprobante comprobante = new Comprobante();
        comprobante.setId(comprobateDto.getId() != null ? comprobateDto.getId() : null);
        comprobante.setCliente(comprobateDto.getClienteId());
        comprobante.setTotal(comprobateDto.getTotal());
        comprobante.setFecha_creacion(comprobateDto.getFecha_creacion());
        comprobante.setCuit_empresa(comprobateDto.getCuit_empresa());
                return comprobante;
    }
}

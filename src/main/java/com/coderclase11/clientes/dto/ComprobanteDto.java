package com.coderclase11.clientes.dto;

import com.coderclase11.clientes.model.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ComprobanteDto {

    private Long id;

    private Cliente clienteId;

    private Date fecha_creacion;

    private BigDecimal total;

    private String cuit_empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCuit_empresa() {
        return cuit_empresa;
    }

    public void setCuit_empresa(String cuit_empresa) {
        this.cuit_empresa = cuit_empresa;
    }
}

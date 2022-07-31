package com.coderclase11.clientes.dto;

import com.coderclase11.clientes.model.Comprobante;
import com.coderclase11.clientes.model.ItemsComprobante;
import com.coderclase11.clientes.model.Producto;

import java.math.BigDecimal;

public class ItemsComprobanteDto {

    private Long id;

    private Producto productoId;

    private Comprobante comprobanteId;

    private String detalle;

    private BigDecimal precio;

    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Comprobante getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(Comprobante comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}









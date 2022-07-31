package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.model.ItemsComprobante;

public class ItemsCompEntityADtoConvert {
    public ItemsComprobanteDto convert(ItemsComprobante itemsComprobante){
        ItemsComprobanteDto itemsComprobanteDto = new ItemsComprobanteDto();
        itemsComprobanteDto.setId(itemsComprobante.getId()!= null ? itemsComprobanteDto.getId() : null);
        itemsComprobanteDto.setComprobanteId(itemsComprobante.getComprobante());
        itemsComprobanteDto.setProductoId(itemsComprobante.getProducto());
        itemsComprobanteDto.setCantidad(itemsComprobante.getCantidad());
        itemsComprobanteDto.setDetalle(itemsComprobante.getDetalle());
        itemsComprobanteDto.setPrecio(itemsComprobante.getPrecio());
        return itemsComprobanteDto;

    }
}

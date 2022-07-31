package com.coderclase11.clientes.converter.dto;

import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.model.ItemsComprobante;

public class ItemsCompDtoAEntityConvert {
    public ItemsComprobante convert(ItemsComprobanteDto itemsComprobanteDto){
        ItemsComprobante itemsComprobante = new ItemsComprobante();
        itemsComprobante.setId(itemsComprobanteDto.getId()!= null ? itemsComprobanteDto.getId() : null);
        itemsComprobante.setComprobante(itemsComprobanteDto.getComprobanteId());
        itemsComprobante.setProducto(itemsComprobanteDto.getProductoId());
        itemsComprobante.setCantidad(itemsComprobanteDto.getCantidad());
        itemsComprobante.setDetalle(itemsComprobanteDto.getDetalle());
        itemsComprobante.setPrecio(itemsComprobanteDto.getPrecio());
            return itemsComprobante;

    }
}

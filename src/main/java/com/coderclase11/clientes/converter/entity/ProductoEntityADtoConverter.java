package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityADtoConverter {

    public ProductoDto convert(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setDescripcion(producto.getDescripcion());
        return productoDto;
    }

}

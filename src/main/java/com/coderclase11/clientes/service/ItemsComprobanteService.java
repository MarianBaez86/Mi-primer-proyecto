package com.coderclase11.clientes.service;


import com.coderclase11.clientes.converter.dto.ItemsCompDtoAEntityConvert;
import com.coderclase11.clientes.converter.entity.ItemsCompEntityADtoConvert;
import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.model.ItemsComprobante;
import com.coderclase11.clientes.model.Producto;
import com.coderclase11.clientes.repository.ItemsComprobanteRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsComprobanteService {

    private final ItemsComprobanteRepository repository;
    private final ItemsCompEntityADtoConvert converter;
    private final ItemsCompDtoAEntityConvert converterDto;


    public ItemsComprobanteService(ItemsComprobanteRepository repository, ItemsCompEntityADtoConvert converter, ItemsCompDtoAEntityConvert converterDto) {
        this.repository = repository;
        this.converter = converter;
        this.converterDto = converterDto;
    }




}

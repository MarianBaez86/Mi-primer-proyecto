package com.coderclase11.clientes.service;


import com.coderclase11.clientes.converter.dto.ComprobanteDtoAEntityConverter;
import com.coderclase11.clientes.converter.entity.ComprobanteEntityADtoConverter;
import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.*;
import com.coderclase11.clientes.repository.ClienteRepository;
import com.coderclase11.clientes.repository.ComprobanteRepository;
import com.coderclase11.clientes.repository.ItemsComprobanteRepository;
import com.coderclase11.clientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class ComprobanteService {
    private final ComprobanteRepository repository;
    private final ComprobanteEntityADtoConverter converter;
    private final ComprobanteDtoAEntityConverter converterDto;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ItemsComprobanteRepository itemsComprobanteRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ComprobanteService(ComprobanteRepository repository, ComprobanteEntityADtoConverter converter, ComprobanteDtoAEntityConverter converterDto) {
        this.repository = repository;
        this.converter = converter;
        this.converterDto = converterDto;
    }

    public List<ComprobanteDto> listarTodosLosComprobantes(){
        List<Comprobante> comprobantes = repository.findAll();
        List<ComprobanteDto> comprobantesDto = new ArrayList<>();
        for (Comprobante comprobante : comprobantes) {
            ComprobanteDto comprobanteDto = this.converter.convert(comprobante);
            comprobantesDto.add(comprobanteDto);
        }
        return comprobantesDto;
    }

    private Boolean validarCliente(Cliente cliente) {
        var clienteAValidar = this.clienteRepository.findById(cliente.getDni());
        return clienteAValidar.isEmpty(); //Ver sisgo de admiración
    }

    private Boolean validarProducto(Set<ItemsComprobante> itemsComprobantes){
        for (ItemsComprobante itemsComprobante: itemsComprobantes){
            var productoId = itemsComprobante.getProducto().getId();
            var productoValidar = this.productoRepository.findById(productoId);
            if (productoValidar.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Boolean validarStock(Set<ItemsComprobante> itemsComprobantes) {
        for (ItemsComprobante itemsComprobante: itemsComprobantes){
            var productoId = itemsComprobante.getProducto().getId();
            var opProducto = this.productoRepository.findById(productoId);
            if (opProducto.isEmpty()) {
                return false;
            }
            if (itemsComprobante.getCantidad() <= opProducto.get().getStock()){
                return true;
            }
        }
        return false;
    }

    public ComprobanteDto crearComprobante(ComprobanteDto comprobanteDto) {
        Comprobante comprobante = this.converterDto.convert(comprobanteDto);
        Boolean validarCliente = validarCliente(comprobante.getCliente());
        Boolean validarProducto = validarProducto(comprobante.getItemsComprobantes());
        Boolean validarStock = validarStock(comprobante.getItemsComprobantes());
        if (validarCliente && validarProducto && validarStock) {

            var comprobanteAGuardar = armarComprobante(comprobante);

            actualizarStock(comprobanteAGuardar.getItemsComprobantes());

            this.repository.save(comprobanteAGuardar);
            return comprobanteDto;

        } else {
            return new ComprobanteDto();// Ver msj de error.
        }
    }

    private Comprobante armarComprobante(Comprobante comprobante) {
        Comprobante comprobanteAGuardar = new Comprobante();

        comprobanteAGuardar.setCliente(this.clienteRepository.findById(comprobante.getCliente().getDni()).get());

        WorldClock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);

        String currentDateTime = worldClock.getCurrentDateTime();
        // "2021-12-08T17:36Z"
        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").parse(currentDateTime);
            comprobanteAGuardar.setFecha_creacion(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            comprobanteAGuardar.setFecha_creacion(new Date());
        }
        comprobanteAGuardar.setItemsComprobantes(new HashSet<ItemsComprobante>());
        for (ItemsComprobante itemsComprobante : comprobante.getItemsComprobantes()){
            comprobanteAGuardar.addItemsComprobante(itemsComprobante);//ver como crear ITEMS
        }

//		comprobanteAGuardar.setLineas(armarLineas(comprobante.getLineas(), comprobanteAGuardar));
        comprobanteAGuardar.setTotal(calcularTotal(comprobanteAGuardar.getItemsComprobantes()));

        return comprobanteAGuardar;
    }

    public ItemsComprobanteDto crearItemComprobante(ItemsComprobanteDto itemsComprobanteDto) {
        ItemsComprobante itemsComprobante = this.converterDto.convert(itemsComprobanteDto);
        Producto productoDB = this.productoRepository.findById(itemsComprobante.getProducto().getId()).get();
        this.repository.save(itemsComprobante);
        return itemsComprobanteDto;
    }

    //VERRRR
    private BigDecimal calcularTotal(Set<ItemsComprobante> itemsComprobantes) {
        BigDecimal total = new BigDecimal("0");

        for (ItemsComprobante itemsComprobante : itemsComprobantes) {
            total = total.add(new BigDecimal(itemsComprobante.getPrecio().toString()));
        }
        return total;
    }

    //Stock
    private void actualizarStock(Set<ItemsComprobante> itemsComprobantes) {
        for (ItemsComprobante itemsComprobante : itemsComprobantes) {
            var cantidadVendida = itemsComprobante.getCantidad();
            var producto = itemsComprobante.getProducto();
            Producto otroProducto = this.productoRepository.getById(producto.getId());
            var stock = otroProducto.getStock();
            var nuevoStock = stock - cantidadVendida;
            otroProducto.setStock(nuevoStock);
            this.productoRepository.save(otroProducto);
        }

    }
}

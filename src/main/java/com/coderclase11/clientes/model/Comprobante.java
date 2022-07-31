package com.coderclase11.clientes.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="COMPROBANTE")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="dni")
    private Cliente cliente;

    //bi-directional one-to-many association to Items
    @OneToMany(mappedBy="comprobante", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ItemsComprobante> itemsComprobantes;

    private Date fecha_creacion;

    private BigDecimal total;

    private String cuit_empresa;


    public Comprobante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemsComprobante> getItemsComprobantes() {
        return itemsComprobantes;
    }

    public void setItemsComprobantes(Set<ItemsComprobante> itemsComprobantes) {
        this.itemsComprobantes = itemsComprobantes;
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


    public ItemsComprobante addItemsComprobante(ItemsComprobante itemsComprobante) {
        getItemsComprobantes().add(itemsComprobante);
        itemsComprobante.setComprobante(this);
                return itemsComprobante;
    }

}







package com.coderclase11.clientes.controller;

import com.coderclase11.clientes.service.ItemsComprobanteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coderhouse/items")
public class ItemsComprobantesController {

        private final ItemsComprobanteService itemsComprobanteService;

        public ItemsComprobantesController(ItemsComprobanteService itemsComprobanteService) {
            this.itemsComprobanteService = itemsComprobanteService;
        }
}

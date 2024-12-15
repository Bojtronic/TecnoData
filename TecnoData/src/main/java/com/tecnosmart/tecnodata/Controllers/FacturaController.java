package com.tecnosmart.tecnodata.controllers;


import com.tecnosmart.tecnodata.models.Factura;
import com.tecnosmart.tecnodata.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas")
    public String listarFacturas(Model model) {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();

        model.addAttribute("facturas", facturas);

        return "productos/admin_facturas";
    }


}

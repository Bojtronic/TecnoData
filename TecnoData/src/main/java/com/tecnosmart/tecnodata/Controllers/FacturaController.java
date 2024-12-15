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

    @GetMapping("/admin_facturas")
    public String listarFacturas(Model model) {
        // Obtener la lista de facturas desde el servicio
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();

        // Pasar la lista de facturas al modelo
        model.addAttribute("facturas", facturas);

        // Retornar el nombre de la plantilla HTML
        return "productos/admin_facturas";
    }


}

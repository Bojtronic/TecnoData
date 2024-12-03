package com.tecnosmart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
    
    @GetMapping("/reparaciones")
    public String reparaciones(Model model) {
        model.addAttribute("titulo", "Servicio de Reparaciones");
        return "servicios/reparaciones";
    }
    
    @GetMapping("/ventas")
    public String ventas(Model model) {
        model.addAttribute("titulo", "Servicio de Ventas");
        return "servicios/ventas";
    }
    
    @GetMapping("/cotizaciones")
    public String cotizaciones(Model model) {
        model.addAttribute("titulo", "Solicitar Cotización");
        return "servicios/cotizaciones";
    }
}
package com.tecnosmart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "TecnoSmart - Inicio");
        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros(Model model) {
        model.addAttribute("titulo", "Sobre Nosotros");
        return "nosotros";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "contacto";
    }
}
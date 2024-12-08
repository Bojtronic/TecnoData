package com.tecnosmart.tecnodata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        return("index");
    }

    @GetMapping("/categorias")
    public String categorias() {
        return "categorias"; // Retorna el archivo categorias.html
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros"; // Retorna el archivo nosotros.html
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios"; // Retorna el archivo servicios.html
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto"; // Retorna el archivo contacto.html
    }
}

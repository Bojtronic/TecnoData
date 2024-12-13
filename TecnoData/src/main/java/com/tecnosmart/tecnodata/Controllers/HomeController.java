package com.tecnosmart.tecnodata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnosmart.tecnodata.models.Categoria;
import com.tecnosmart.tecnodata.services.CategoriaService;

@Controller
public class HomeController {
    
    
    //private final ProductoService productoService;

    /*
    public HomeController(ProductoService productoService) {
        this.productoService = productoService;
    }
    */
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();
        List<Categoria> categoriasMasVendidas = categorias.stream()
            .filter(categoria -> categoria.getCantidadVentas() > 50)
            .toList();
        model.addAttribute("categorias", categoriasMasVendidas);
        return "index";
    }

    /*
    @GetMapping("/categorias")
    public String categorias() {
        return "categorias"; // Retorna el archivo categorias.html
    }
    */

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

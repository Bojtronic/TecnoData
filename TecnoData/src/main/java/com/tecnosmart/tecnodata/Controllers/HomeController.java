package com.tecnosmart.tecnodata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnosmart.tecnodata.models.Categoria;
import com.tecnosmart.tecnodata.models.Producto;
import com.tecnosmart.tecnodata.services.*;

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

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String home(Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();
        List<Categoria> categoriasMasVendidas = categorias.stream()
            .filter(categoria -> categoria.getCantidadVentas() > 50)
            .toList();
        model.addAttribute("categorias", categoriasMasVendidas);

        List<Producto> productos = productoService.listarProductos();
        List<Producto> productosMasVendidos = productos.stream()
            .sorted((p1, p2) -> Integer.compare(p2.getCantidadVentas(), p1.getCantidadVentas())) // Orden descendente
            .limit(10) // Limitar a los 10 primeros
            .toList();
        model.addAttribute("productos", productosMasVendidos);
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

package com.tecnosmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tecnosmart.models.Producto;
import com.tecnosmart.services.ProductoService;
import com.tecnosmart.services.CategoriaService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("titulo", "Productos");
        model.addAttribute("productos", productoService.findAll());
        return "productos/lista";
    }
    
    @GetMapping("/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        productoService.findById(id).ifPresent(producto -> {
            model.addAttribute("producto", producto);
            model.addAttribute("titulo", producto.getNombre());
        });
        return "productos/detalle";
    }
    
    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/productos/form";
    }
    
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        productoService.findById(id).ifPresent(producto -> {
            model.addAttribute("producto", producto);
            model.addAttribute("categorias", categoriaService.findAll());
            model.addAttribute("titulo", "Editar Producto");
        });
        return "productos/form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }
    
    @GetMapping("/buscar")
    public String buscarProductos(@RequestParam String nombre, Model model) {
        model.addAttribute("productos", productoService.findByNombreContaining(nombre));
        model.addAttribute("titulo", "Resultados de búsqueda");
        return "productos/lista";
    }
}
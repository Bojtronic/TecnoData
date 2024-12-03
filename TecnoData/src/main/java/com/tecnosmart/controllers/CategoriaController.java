package com.tecnosmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tecnosmart.models.Categoria;
import com.tecnosmart.services.CategoriaService;
import com.tecnosmart.services.ProductoService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("titulo", "Categorías");
        return "categorias/lista";
    }
    
    @GetMapping("/{id}")
    public String verCategoria(@PathVariable Long id, Model model) {
        categoriaService.findById(id).ifPresent(categoria -> {
            model.addAttribute("categoria", categoria);
            model.addAttribute("productos", productoService.findByCategoriaId(id));
            model.addAttribute("titulo", categoria.getNombre());
        });
        return "categorias/productos";
    }
    
    @GetMapping("/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("titulo", "Nueva Categoría");
        return "categorias/form";
    }
    
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        categoriaService.findById(id).ifPresent(categoria -> {
            model.addAttribute("categoria", categoria);
            model.addAttribute("titulo", "Editar Categoría");
        });
        return "categorias/form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        if (!categoriaService.tieneProductos(id)) {
            categoriaService.deleteById(id);
        }
        return "redirect:/categorias";
    }
}
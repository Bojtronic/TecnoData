package com.tecnosmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tecnosmart.models.Producto;
import com.tecnosmart.models.Categoria;
import com.tecnosmart.services.ProductoService;
import com.tecnosmart.services.CategoriaService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    // Panel de administración
    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("titulo", "Panel de Administración");
        return "admin/index";
    }

    // Gestión de Productos
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("titulo", "Gestión de Productos");
        return "admin/productos/lista";
    }

    @GetMapping("/productos/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("titulo", "Nuevo Producto");
        return "admin/productos/form";
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/admin/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProductoForm(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.findById(id).orElse(new Producto()));
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("titulo", "Editar Producto");
        return "admin/productos/form";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos";
    }

    // Gestión de Categorías
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("titulo", "Gestión de Categorías");
        return "admin/categorias/lista";
    }

    @GetMapping("/categorias/nueva")
    public String nuevaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("titulo", "Nueva Categoría");
        return "admin/categorias/form";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/admin/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.findById(id).orElse(new Categoria()));
        model.addAttribute("titulo", "Editar Categoría");
        return "admin/categorias/form";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/admin/categorias";
    }
}
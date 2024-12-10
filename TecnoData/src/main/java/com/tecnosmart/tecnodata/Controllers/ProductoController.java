package com.tecnosmart.tecnodata.controllers;

import com.tecnosmart.tecnodata.models.Producto;
import com.tecnosmart.tecnodata.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Leer: Listar todos los productos
    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "productos/listar"; // Vista para mostrar la lista de productos
    }

    // Crear: Mostrar formulario para un nuevo producto
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/nuevo"; // Vista para crear un nuevo producto
    }

    // Crear: Guardar el nuevo producto
    @PostMapping
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    // Leer: Ver un producto por ID
    @GetMapping("/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/ver"; // Vista para mostrar los detalles de un producto
        } else {
            return "redirect:/productos"; // Redirigir si el producto no existe
        }
    }

    // Actualizar: Mostrar formulario para editar un producto
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/editar"; // Vista para editar un producto
        } else {
            return "redirect:/productos";
        }
    }

    // Actualizar: Guardar cambios en el producto
    @PostMapping("/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto) {
        producto.setId(id); // Asegurarse de que la actualización afecta al producto correcto
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    // Eliminar: Eliminar un producto
    @GetMapping("/{id}/eliminar")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.obtenerProductoPorId(id).ifPresent(producto -> productoService.eliminar(producto.getId()));
        return "redirect:/productos";
    }
}

package com.tecnosmart.tecnodata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tecnosmart.tecnodata.models.*;
import com.tecnosmart.tecnodata.services.ProductoService;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

    @Autowired
    private ProductoService productoService;

    // Configura el carrito como un atributo de sesión
    @ModelAttribute("carrito")
    public CarritoCompras carrito() {
        return new CarritoCompras();
    }

    // Agrega un producto al carrito
    @PostMapping("/agregar")
    public String agregarProducto(@RequestParam Long productoId, 
                                   @ModelAttribute("carrito") CarritoCompras carrito) {
        Producto producto = productoService.obtenerProductoPorId(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productoId));
        carrito.agregarProducto(producto);
        return "redirect:/productos"; // Redirige a la pagina de productos después de agregar
    }

    // Muestra el carrito de compras
    @GetMapping
    public String verCarrito(@ModelAttribute("carrito") CarritoCompras carrito, Model model) {
        model.addAttribute("productosCarrito", carrito.getProductos());
        model.addAttribute("total", carrito.calcularTotal());
        return "productos/carrito"; // Retorna la vista del carrito
    }

    // Elimina un producto del carrito
    @PostMapping("/eliminar")
    public String eliminarProducto(@RequestParam Long productoId, 
                                    @ModelAttribute("carrito") CarritoCompras carrito) {
        Producto producto = productoService.obtenerProductoPorId(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productoId));
        carrito.eliminarProducto(producto);
        return "redirect:/carrito"; // Redirige a la vista del carrito después de eliminar
    }
}

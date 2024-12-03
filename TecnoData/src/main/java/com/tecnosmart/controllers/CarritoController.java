package com.tecnosmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tecnosmart.services.CarritoService;
import com.tecnosmart.services.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    
    @Autowired
    private CarritoService carritoService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.getItems());
        model.addAttribute("total", carritoService.calcularTotal());
        model.addAttribute("titulo", "Carrito de Compras");
        return "carrito/ver";
    }
    
    @PostMapping("/agregar")
    public String agregarProducto(@RequestParam Long productoId) {
        carritoService.agregarProducto(productoId);
        return "redirect:/carrito";
    }
    
    @PostMapping("/actualizar")
    public String actualizarCantidad(@RequestParam Long productoId, 
                                   @RequestParam Integer cantidad) {
        carritoService.actualizarCantidad(productoId, cantidad);
        return "redirect:/carrito";
    }
    
    @GetMapping("/eliminar/{productoId}")
    public String eliminarProducto(@PathVariable Long productoId) {
        carritoService.eliminarProducto(productoId);
        return "redirect:/carrito";
    }
    
    @PostMapping("/limpiar")
    public String limpiarCarrito() {
        carritoService.limpiar();
        return "redirect:/carrito";
    }
}
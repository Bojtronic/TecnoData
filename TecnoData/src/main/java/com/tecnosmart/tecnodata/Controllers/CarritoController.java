package com.tecnosmart.tecnodata.controllers;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tecnosmart.tecnodata.models.*;
import com.tecnosmart.tecnodata.services.FacturaService;
import com.tecnosmart.tecnodata.services.PDFService;
import com.tecnosmart.tecnodata.services.ProductoService;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PDFService pdfService;

    // Configura el carrito como un atributo de sesión
    @ModelAttribute("carrito")
    public CarritoCompras carrito() {
        return new CarritoCompras();
    }

    @GetMapping("/ver")
    public String mostrarCarrito(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "success", required = false) String success,
                                  @ModelAttribute("carrito") CarritoCompras carrito,
                                  Model model) {
        if (error != null) {
            model.addAttribute("error", "El carrito está vacío. No se puede realizar la compra.");
        }
        if (success != null) {
            model.addAttribute("success", "Compra realizada con éxito. ¡Gracias por su compra!");
        }

        model.addAttribute("productosCarrito", carrito.getProductos());
        model.addAttribute("total", carrito.calcularTotal());
        return "productos/carrito"; // Retorna la vista del carrito
    }

    @PostMapping("/comprar")
    public String realizarCompra(@ModelAttribute("carrito") CarritoCompras carrito) {
        if (carrito.getProductos().isEmpty()) {
            return "redirect:/carrito?error=empty";
        }

        // Crear factura
        Factura factura = new Factura();
        factura.setFecha(LocalDate.now());
        factura.setTotal(BigDecimal.valueOf(carrito.calcularTotal()));

        List<DetalleFactura> detalles = carrito.getProductos().entrySet().stream().map(entry -> {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setProducto(entry.getKey());
            detalle.setCantidad(entry.getValue());
            detalle.setSubtotal(new BigDecimal(entry.getKey().getPrecio().toString()).multiply(new BigDecimal(entry.getValue())));
            detalle.setFactura(factura);
            return detalle;
        }).toList();

        factura.setDetalles(detalles);

        // Guardar en la base de datos
        facturaService.guardarFactura(factura);

        // Generar PDF
        pdfService.generarFacturaPDF(factura);

        // Limpiar el carrito
        carrito.limpiar();

        return "redirect:/carrito?success=compraRealizada";
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
        // Buscar el producto en el carrito por su ID y eliminarlo
        Producto productoAEliminar = carrito.getProductos().keySet().stream()
                .filter(producto -> producto.getId().equals(productoId))
                .findFirst()
                .orElse(null);

        if (productoAEliminar != null) {
            carrito.eliminarProducto(productoAEliminar);
        }

        return "redirect:/carrito"; // Redirige a la vista del carrito después de eliminar
    }
}

package com.tecnosmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnosmart.models.Producto;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarritoService {
    
    @Autowired
    private ProductoService productoService;
    
    // Mapa para almacenar los items del carrito: ProductoId -> Cantidad
    private Map<Long, Integer> items = new HashMap<>();
    
    // Agregar producto al carrito
    public void agregarProducto(Long productoId) {
        Producto producto = productoService.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
        if (producto.getStock() > 0) {
            items.merge(productoId, 1, Integer::sum);
        }
    }
    
    // Eliminar producto del carrito
    public void eliminarProducto(Long productoId) {
        items.remove(productoId);
    }
    
    // Actualizar cantidad de un producto
    public void actualizarCantidad(Long productoId, Integer cantidad) {
        Producto producto = productoService.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
        if (cantidad <= 0) {
            items.remove(productoId);
        } else if (cantidad <= producto.getStock()) {
            items.put(productoId, cantidad);
        }
    }
    
    // Obtener todos los items del carrito
    public Map<Long, Integer> getItems() {
        return items;
    }
    
    // Calcular subtotal del carrito
    public BigDecimal calcularSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
            Producto producto = productoService.findById(entry.getKey())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            subtotal = subtotal.add(producto.getPrecio()
                .multiply(new BigDecimal(entry.getValue())));
        }
        return subtotal;
    }
    
    // Calcular IVA (13%)
    public BigDecimal calcularIVA() {
        return calcularSubtotal().multiply(new BigDecimal("0.13"));
    }
    
    // Calcular total (subtotal + IVA)
    public BigDecimal calcularTotal() {
        return calcularSubtotal().add(calcularIVA());
    }
    
    // Obtener cantidad total de items en el carrito
    public int getCantidadTotal() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    // Verificar si el carrito está vacío
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    // Limpiar el carrito
    public void limpiar() {
        items.clear();
    }
    
    // Procesar la compra
    public void procesarCompra() {
        // Actualizar stock de productos
        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
            productoService.actualizarStock(entry.getKey(), entry.getValue());
        }
        // Limpiar el carrito después de la compra
        limpiar();
    }
}
package com.tecnosmart.tecnodata.models;

import java.util.HashMap;
import java.util.Map;

public class CarritoCompras {
    private Map<Producto, Integer> productos = new HashMap<>();

    public void agregarProducto(Producto producto) {
        productos.put(producto, productos.getOrDefault(producto, 0) + 1);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        return productos.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
                .sum();
    }
}

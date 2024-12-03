package com.tecnosmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnosmart.models.Producto;
import com.tecnosmart.repositorie.ProductoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    // Obtener todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
    
    // Obtener producto por ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }
    
    // Guardar producto
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
    
    // Eliminar producto
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
    
    // Buscar productos por categoría
    public List<Producto> findByCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }
    
    // Buscar productos por nombre
    public List<Producto> findByNombreContaining(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    // Actualizar stock
    public void actualizarStock(Long productoId, Integer cantidad) {
        Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }
}
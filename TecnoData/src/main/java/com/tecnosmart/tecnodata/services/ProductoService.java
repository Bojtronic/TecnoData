package com.tecnosmart.tecnodata.services;

import java.util.List;
import java.util.Optional;

import com.tecnosmart.tecnodata.models.Producto;

public interface ProductoService {

    Producto guardar(Producto producto);
    
    List<Producto> listarProductos();

    List<Producto> listarProductosPorCategoria(Long categoriaId);
    
    Optional<Producto> obtenerProductoPorId(Long id);
    
    List<Producto> buscarProductosPorNombre(String nombre);
    
    List<Producto> buscarProductosPorCategoria(Long categoriaId);
    
    void actualizarStock(Long productoId, Integer cantidad);

    void eliminar(Long id);
}


package com.tecnosmart.tecnodata.services;

import com.tecnosmart.tecnodata.models.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria guardar(Categoria categoria);
    
    List<Categoria> listarCategorias();
    
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    
    void eliminar(Long id);
}

package com.tecnosmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnosmart.models.Categoria;
import com.tecnosmart.repositorie.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    // Obtener todas las categorías
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    // Obtener categoría por ID
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    
    // Guardar categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    // Eliminar categoría
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
    
 // Buscar categoría por nombre
    public Categoria findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
  
    }
    
    // Verificar si una categoría tiene productos
    public boolean tieneProductos(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(c -> !c.getProductos().isEmpty()).orElse(false);
    }
}
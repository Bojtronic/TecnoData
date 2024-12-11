package com.tecnosmart.tecnodata.repositories;

import com.tecnosmart.tecnodata.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Método para buscar categorías por nombre exacto
    List<Categoria> findByNombre(String nombre);

    // Método para buscar categorías por una coincidencia parcial del nombre (insensible a mayúsculas y minúsculas)
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}

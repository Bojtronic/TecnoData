package com.tecnosmart.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnosmart.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNombre(String nombre);  // Cambiado de Optional<Categoria> a Categoria
}
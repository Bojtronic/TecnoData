package com.tecnosmart.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnosmart.models.Producto;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaId(Long categoriaId);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
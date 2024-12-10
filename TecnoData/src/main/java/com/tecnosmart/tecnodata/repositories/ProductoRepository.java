package com.tecnosmart.tecnodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnosmart.tecnodata.models.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}



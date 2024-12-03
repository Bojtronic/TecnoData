package com.tecnosmart.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnosmart.models.Orden;
import com.tecnosmart.models.Usuario;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findByUsuarioOrderByFechaDesc(Usuario usuario);
}
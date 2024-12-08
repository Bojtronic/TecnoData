package com.tecnosmart.tecnodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnosmart.tecnodata.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar un usuario por su email
    Usuario findByEmail(String email);
}

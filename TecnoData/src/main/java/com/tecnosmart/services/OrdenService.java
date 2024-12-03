package com.tecnosmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnosmart.models.Orden;
import com.tecnosmart.models.Usuario;
import com.tecnosmart.repositorie.OrdenRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {
    
    @Autowired
    private OrdenRepository ordenRepository;
    
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }
    
    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }
    
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }
    
    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }
    
    public List<Orden> findByUsuario(Usuario usuario) {
        return ordenRepository.findByUsuarioOrderByFechaDesc(usuario);
    }
}
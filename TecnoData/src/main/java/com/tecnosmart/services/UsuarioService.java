package com.tecnosmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tecnosmart.models.Usuario;
import com.tecnosmart.repositorie.UsuarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public Usuario save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
    
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public boolean existeEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
package com.tecnosmart.tecnodata.services;

import com.tecnosmart.tecnodata.models.Usuario;
import com.tecnosmart.tecnodata.repositories.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Carga un usuario basado en su correo electrónico.
     * 
     * @param email Correo electrónico del usuario.
     * @return UserDetails para ser usado por Spring Security.
     * @throws UsernameNotFoundException Si no se encuentra el usuario.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.getRol().toUpperCase()) // Asignar roles dinámicos desde el modelo.
                .build();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param usuario Usuario a registrar.
     * @return true si el registro fue exitoso, false si el usuario ya existe.
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return false; // El usuario ya existe.
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Codificar la contraseña.
        usuarioRepository.save(usuario);
        return true;
    }

    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param usuario Usuario con información actualizada.
     * @return true si la actualización fue exitosa, false si el usuario no existe.
     */
    public boolean actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getId()).isEmpty()) {
            return false; // Usuario no encontrado.
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Codificar la nueva contraseña.
        usuarioRepository.save(usuario);
        return true;
    }

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false si el usuario no existe.
     */
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.findById(id).isEmpty()) {
            return false; // Usuario no encontrado.
        }
        usuarioRepository.deleteById(id);
        return true;
    }

    /**
     * Recupera todos los usuarios de la base de datos.
     * 
     * @return Lista de usuarios.
     */
        public List<Usuario> obtenerTodosLosUsuarios() {
            return usuarioRepository.findAll(); // Llama al método findAll() de JpaRepository
        }
}

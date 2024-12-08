package com.tecnosmart.tecnodata.controllers;

import com.tecnosmart.tecnodata.services.UsuarioService;
import com.tecnosmart.tecnodata.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para obtener todos los usuarios y mostrarlos en consola.
     * 
     * @return Lista de usuarios.
     */
    @GetMapping("/usuarios")
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        usuarios.forEach(usuario -> System.out.println(usuario)); // Imprime los usuarios en consola
        return usuarios;
    }
}

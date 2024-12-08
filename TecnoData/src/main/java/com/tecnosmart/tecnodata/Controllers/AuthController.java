package com.tecnosmart.tecnodata.controllers;

import com.tecnosmart.tecnodata.models.Usuario;
import com.tecnosmart.tecnodata.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Muestra la página de inicio de sesión.
     */
    @GetMapping("/login")
    public String login() {
        return "autenticacion/login"; // Ruta de tu plantilla de inicio de sesión
    }

    /**
     * Muestra la página de registro.
     */
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "autenticacion/registro"; // Ruta de tu plantilla de registro
    }

    /**
     * Procesa el formulario de registro de usuario.
     * 
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @param rol Rol del usuario (opcional, por defecto "USER").
     * @param model Modelo para pasar datos a la vista.
     * @return Redirección o vista dependiendo del resultado del registro.
     */
    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombre,
                                    @RequestParam String apellido,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam(defaultValue = "USER") String rol,
                                    Model model) {
        // Crear un objeto Usuario con los datos del formulario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol(rol);

        // Registrar el usuario utilizando el servicio
        boolean registroExitoso = usuarioService.registrarUsuario(usuario);

        if (registroExitoso) {
            model.addAttribute("message", "Registro exitoso. Ahora puedes iniciar sesión.");
            return "redirect:/login"; // Redirige al login después de registrarse
        } else {
            model.addAttribute("error", "El correo ya está registrado. Intenta nuevamente.");
            return "autenticacion/registro"; // Muestra el formulario nuevamente con error
        }
    }
}

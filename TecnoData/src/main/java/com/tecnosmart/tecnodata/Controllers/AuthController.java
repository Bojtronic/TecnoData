package com.tecnosmart.tecnodata.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    
    @GetMapping("/login")
    public String login() {
        return "autenticacion/login";
    }

    // Mostrar página de registro
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "autenticacion/registro"; // Ruta de tu plantilla de registro
    }

    // Procesar formulario de registro
    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    Model model) {
        // Aquí puedes agregar la lógica para registrar al usuario.
        // Por ejemplo, verificar si el usuario ya existe o guardar el usuario en la base de datos.

        boolean registroExitoso = true; // Simulación de éxito en el registro

        if (registroExitoso) {
            model.addAttribute("message", "Registro exitoso. Ahora puedes iniciar sesión.");
            return "redirect:/login"; // Redirige al login después de registrarse
        } else {
            model.addAttribute("error", "Error al registrar el usuario. Intenta nuevamente.");
            return "autenticacion/registro";
        }
    }
}

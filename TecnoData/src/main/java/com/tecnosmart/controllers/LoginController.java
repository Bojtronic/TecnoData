package com.tecnosmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecnosmart.dto.RegistroDTO;
import com.tecnosmart.models.Usuario;
import com.tecnosmart.services.UsuarioService;
import com.tecnosmart.utils.AppConstants;

@Controller
public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login-page")
    public String login(Model model) {
        model.addAttribute("titulo", "Login - TecnoSmart");
        //return "autenticacion/login";
        return "redirect:/login-page";
    }
    
    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("titulo", "Registro - TecnoSmart");
        model.addAttribute("registroDTO", new RegistroDTO());
        return "registro";
    }
    
    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute RegistroDTO registroDTO, 
                                 RedirectAttributes redirectAttributes) {
        // Validar que las contraseñas coincidan
        if (!registroDTO.getPassword().equals(registroDTO.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/registro";
        }
        
        // Verificar si el email ya existe
        if (usuarioService.existeEmail(registroDTO.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "El email ya está registrado");
            return "redirect:/registro";
        }
        
        // Crear nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(registroDTO.getNombre());
        usuario.setApellido(registroDTO.getApellido());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        usuario.setRol(AppConstants.ROLE_USER);
        
        // Guardar usuario
        usuarioService.save(usuario);
        
        redirectAttributes.addFlashAttribute("success", "Registro exitoso. Por favor, inicia sesión");
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}
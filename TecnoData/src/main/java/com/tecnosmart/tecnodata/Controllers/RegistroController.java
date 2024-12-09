package com.tecnosmart.tecnodata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnosmart.tecnodata.services.*;

@Controller
public class RegistroController {

	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "autenticacion/login";
	}
	
	@GetMapping("/home")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index";
	}
}

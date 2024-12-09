package com.tecnosmart.tecnodata.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tecnosmart.tecnodata.controllers.dto.*;
import com.tecnosmart.tecnodata.models.*;


public interface UsuarioService extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}

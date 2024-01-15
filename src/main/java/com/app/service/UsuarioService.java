package com.app.service;

import java.util.List;

import com.app.models.Usuario;

public interface UsuarioService {

	public Usuario registrarActualizar(Usuario bean);
	
	public List<Usuario>listado();
	
	public void eliminar(String idUsuario);
	
	public Usuario buscarPorId(String idUsuario);
	
	
}

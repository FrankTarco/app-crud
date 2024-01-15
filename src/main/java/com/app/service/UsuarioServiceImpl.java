package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Usuario;
import com.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public Usuario registrarActualizar(Usuario bean) {
		// TODO Auto-generated method stub
		return repo.save(bean);
	}

	@Override
	public List<Usuario> listado() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void eliminar(String idUsuario) {
		// TODO Auto-generated method stub
		repo.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorId(String idUsuario) {
		// TODO Auto-generated method stub
		return repo.encontrarPorId(idUsuario);
	}

}

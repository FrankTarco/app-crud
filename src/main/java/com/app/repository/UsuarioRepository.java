package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("select u from Usuario u where u.id_usuario= ?1")
	public Usuario encontrarPorId(String id);
	
}

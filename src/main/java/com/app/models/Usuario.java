package com.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuario")
@Getter
@Setter
public class Usuario {

	@Id
	@Column(name="Usuario_Cod")
	private String id_usuario;
	
	@Column(name="Usuario_Nom")
	private String nombre;
	
	@Column(name="Usuario_apellidos")
	private String apellidos;
	
	
}

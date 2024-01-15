package com.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Usuario;
import com.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<?>registrar(@RequestBody Usuario obj){
		
		HashMap<String, Object> salida = new HashMap<>();
		
		Usuario registro = service.registrarActualizar(obj);
		
		if(registro != null) {
			salida.put("mensaje", "Se registro correctamente");
			salida.put("status", true);
		}
		else {
			salida.put("mensaje", "No se concetro el registro");
			salida.put("status", false);
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	public ResponseEntity<?>actualizar(@RequestBody Usuario obj){
		
		HashMap<String, Object> salida = new HashMap<>();
		
		Usuario usuario_buscar = service.buscarPorId(obj.getId_usuario());
		
		if(usuario_buscar != null) {
			Usuario registro = service.registrarActualizar(obj);
			
			if(registro != null) {
				salida.put("mensaje", "Se registro correctamente");
				salida.put("status", true);
			}
			else {
				salida.put("mensaje", "No se concetro el registro");
				salida.put("status", false);
			}
		}
		else {
			
			salida.put("mensaje", "El codigo de usuario no existe");
			salida.put("status", false);
			
		}
		
		
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>actualizar(@PathVariable("id")String id){
		HashMap<String, Object> salida = new HashMap<>();
		
		
		Usuario usuario_buscar = service.buscarPorId(id);
		
		if(usuario_buscar != null) {
			service.eliminar(id);
			salida.put("mensaje", "Se elimino correctamente");
			salida.put("status", true);
		}
		else {
			salida.put("mensaje", "El codigo de usuario no existe");
			salida.put("status", false);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	
	@GetMapping
	public ResponseEntity<?>listado(){
		return ResponseEntity.ok(service.listado());
	}
	
}

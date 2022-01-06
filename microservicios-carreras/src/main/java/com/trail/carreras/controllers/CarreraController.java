package com.trail.carreras.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trail.carreras.models.entity.Carrera;
import com.trail.carreras.models.services.ICarreraService;

@RestController
public class CarreraController {
	
	@Autowired
	private ICarreraService service;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		
		Optional<Carrera> o = service.findById(id);
		if (o.isPresent()) {
			
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Carrera carrera){
		 Carrera carreradb = service.save(carrera);
		 return ResponseEntity.status(HttpStatus.CREATED).body(carreradb);	 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?>editar(@RequestBody Carrera carrera, @PathVariable Long id){
		
		Optional <Carrera> o = service.findById(id);
		
		if(o.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		Carrera carreraDb =  o.get();
		
		carreraDb.setNombre(carrera.getNombre());
		carreraDb.setDescripcion(carrera.getDescripcion());
		carreraDb.setResultados(carrera.getResultados());
		carreraDb.setUrl(carrera.getUrl());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(carreraDb));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminar (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

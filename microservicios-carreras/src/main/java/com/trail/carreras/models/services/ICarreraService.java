package com.trail.carreras.models.services;

import java.util.Optional;

import com.trail.carreras.models.entity.Carrera;

public interface ICarreraService {
	
	public Iterable<Carrera> findAll();
	
	public Optional<Carrera> findById(Long id);
	
	public Carrera save(Carrera carrera);
	
	public void deleteById(Long id);

}

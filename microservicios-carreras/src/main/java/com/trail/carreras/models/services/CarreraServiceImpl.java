package com.trail.carreras.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trail.carreras.models.entity.Carrera;
import com.trail.carreras.models.repository.CarreraRepository;

@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findAll() {
		return carreraRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Carrera> findById(Long id) {
		return carreraRepository.findById(id);
	}

	@Override
	@Transactional
	public Carrera save(Carrera carrera) {
		return carreraRepository.save(carrera);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		carreraRepository.deleteById(id);

	}

}

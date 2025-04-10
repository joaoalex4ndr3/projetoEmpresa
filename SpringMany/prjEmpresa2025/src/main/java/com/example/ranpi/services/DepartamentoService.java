package com.example.ranpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ranpi.entitites.Departamento;
import com.example.ranpi.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	private DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public Departamento getDepartamentoByid(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}

	public List<Departamento> getAllDepartamentos() {
		return departamentoRepository.findAll();
	}

	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
}

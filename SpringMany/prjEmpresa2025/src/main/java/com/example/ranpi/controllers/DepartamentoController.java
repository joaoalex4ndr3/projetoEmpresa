package com.example.ranpi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ranpi.entitites.Departamento;
import com.example.ranpi.services.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	private final DepartamentoService departamentosService;

	public DepartamentoController(DepartamentoService departamentosService) {
		this.departamentosService = departamentosService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> findDepartamentoById(@PathVariable Long id) {
		Departamento departamento = departamentosService.getDepartamentoByid(id);

		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Departamento>> findAllDepartamentos() {
		return ResponseEntity.ok(departamentosService.getAllDepartamentos());
	}

	@PostMapping("/")
	public ResponseEntity<Departamento> insertDepartamento(@RequestBody Departamento departamento) {
		Departamento novoDepartamento = departamentosService.saveDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}
}

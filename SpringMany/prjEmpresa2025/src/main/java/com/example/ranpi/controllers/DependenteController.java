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

import com.example.ranpi.entitites.Dependente;
import com.example.ranpi.services.DependenteService;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

	private final DependenteService dependenteService;

	public DependenteController(DependenteService dependenteService) {
		this.dependenteService = dependenteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dependente> findDependenteById(@PathVariable Long id) {
		Dependente dependente = dependenteService.getDependenteById(id);

		if (dependente != null) {
			return ResponseEntity.ok(dependente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Dependente>> findAllDependentes() {
		List<Dependente> dependentes = dependenteService.getAllDependentes();
		return ResponseEntity.ok(dependentes);
	}

	@PostMapping("/")
	public ResponseEntity<Dependente> insertDependente(@RequestBody Dependente dependente) {
		Dependente novoDependente = dependenteService.saveDependente(dependente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);
	}
}

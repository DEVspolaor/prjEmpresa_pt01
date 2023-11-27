package com.senai.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.senai.PrjEmpresa.entities.Departamento;
import com.senai.PrjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

public class DepartamentoController {

private final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza um departamento por ID")
	public ResponseEntity<Departamento> findDepartamentobyId(@PathVariable Long Depcodigo) {
		Departamento departamento = departamentoService.findDepartamentoById(Depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Apresenta todos os departamentos")
	public ResponseEntity<List<Departamento>> findAlldepartamentocontrol() {
		List<Departamento> departamento = departamentoService.findAllDepartamento();
		return ResponseEntity.ok(departamento);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra um departamento")
	public ResponseEntity<Departamento> insertDepartamentoControl(@RequestBody @Valid Departamento departamento) {
		Departamento novoDepartamento = departamentoService.insertDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualiza um departamento")
	public ResponseEntity<Departamento> updateDepartamentoControl(@PathVariable Long Depcodigo, @RequestBody @Valid Departamento departamento) {
		Departamento mudadepartamento= departamentoService.updateDepartamento(Depcodigo, departamento);
		if (mudadepartamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um departamento")
	public ResponseEntity<String> deleteDepartamentoControl(@PathVariable Long Depcodigo) {
		boolean remover = departamentoService.deleteDepartamento(Depcodigo);
		if (remover) {
			return ResponseEntity.ok().body("departamento Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

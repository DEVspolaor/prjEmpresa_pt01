package com.senai.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.PrjEmpresa.entities.Departamento;
import com.senai.PrjEmpresa.repositories.DepartamentoRepository;


@Service
public class DepartamentoService {
	
private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	// preparando as buscas por id
	public Departamento findDepartamentoById(Long Depcodigo) {
		Optional<Departamento> Departamento = departamentoRepository.findById(Depcodigo);
		return Departamento.orElse(null);
	}

	// preparando a busca geral
	public List<Departamento> findAllDepartamento() {
		return departamentoRepository.findAll();
	}

	// salvando o Jogo
	public Departamento insertDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	// fazendo o update do jogo com o optional
	public Departamento updateDepartamento(Long Depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(Depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepname(novoDepartamento.getDepname());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteDepartamento(Long Depcodigo) {
		Optional<Departamento> departamentoExistente = departamentoRepository.findById(Depcodigo);
		if (departamentoExistente.isPresent()) {
			departamentoRepository.deleteById(Depcodigo);
			return true;
		} else {
			return false;
		}
	}
}


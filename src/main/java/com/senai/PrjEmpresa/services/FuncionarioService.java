package com.senai.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.PrjEmpresa.entities.Funcionario;
import com.senai.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	// preparando as buscas por id
	public Funcionario findFuncionarioById(Long id) {
		Optional<Funcionario> Funcionario = funcionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}

	
	
	public List<Funcionario> findAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	
	public Funcionario insertFuncionario(Funcionario Funcionario) {
		return funcionarioRepository.save(Funcionario);
	}

	
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
		Optional<Funcionario> FuncionarioOptional = funcionarioRepository.findById(id);
		if (FuncionarioOptional.isPresent()) {
			Funcionario FuncionarioExistente = FuncionarioOptional.get();
			FuncionarioExistente.setNome(novoFuncionario.getNome());
			FuncionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			return funcionarioRepository.save(FuncionarioExistente);
		} else {
			return null;
		}
	}


	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> FuncionarioExistente = funcionarioRepository.findById(id);
		if (FuncionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
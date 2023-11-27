package com.senai.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.PrjEmpresa.entities.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
package com.example.ranpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ranpi.entitites.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

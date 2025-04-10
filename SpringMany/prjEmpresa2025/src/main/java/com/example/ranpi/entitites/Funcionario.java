package com.example.ranpi.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String funcNome;

	private double funSalario;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Funcionario(Long id, String funcNome, double funSalario, Departamento departamento) {
		super();
		this.id = id;
		this.funcNome = funcNome;
		this.funSalario = funSalario;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncNome() {
		return funcNome;
	}

	public void setFuncNome(String funcNome) {
		this.funcNome = funcNome;
	}

	public double getFunSalario() {
		return funSalario;
	}

	public void setFunSalario(double funSalario) {
		this.funSalario = funSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}

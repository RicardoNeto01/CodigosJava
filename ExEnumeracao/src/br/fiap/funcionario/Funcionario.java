package br.fiap.funcionario;

import br.fiap.cargo.Cargo;

public class Funcionario {
	private String nome;
	private double salario; 
	private Cargo cargo;
	
	public Funcionario(String nome, double salario, Cargo cargo) {
		this.setNome(nome);
		this.setSalario(salario);
		this.setCargo(cargo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
			return cargo;
		}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}

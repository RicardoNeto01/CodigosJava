package project.contas;

import java.util.Random;

public class Conta {
	
	//Atributos
	private String nome;
	private String tipoConta;
	private int numConta;
	private double saldo;
	private boolean status;
	
	//Construtor
	public Conta() {
		this.setSaldo(0);
		this.setStatus(false);
		this.setNumConta();
	}
	
	public void abrirConta() {
		this.setStatus(true);
	}
	
	public void fecharConta() {
		this.setStatus(false);
	}

	public void sacar(double valor) {
		this.setSaldo(getSaldo() - valor);
	}
	
	public void depositar(double valor) {
		this.setSaldo(getSaldo() + valor); 
	}
	
	//verifica se saldo é maior que 0
	public boolean verificaSaldo() {
		if(this.getSaldo()>0) {
			return true;
		}
		return false;
	}
	//Retorna todos os dados da classe.
	public String getDados() {
		return "Nome: " + this.getNome() + "\n" + "Número da conta: " +this.getNumConta() + "\n" + "Tipo da Conta: " + this.getTipoConta() + "\n" + "Saldo: "+ this.getSaldo() + "\n" + "Conta aberta? "+ this.getStatus();
	}
	
	//Gera número de conta.
	private int geraNumConta() {
		int n;
		Random r = new Random();
		n = r.nextInt(10000000, 99999999);
		return n;
	}
	
	//Adiciona um valor de acordo com o tipo da conta.
	public void tipoConta() {
		if(this.getTipoConta().equalsIgnoreCase("CP")) {
			this.setSaldo(getSaldo() + 150);
		}else {
			if(this.getTipoConta().equalsIgnoreCase("CC")) {
				this.setSaldo(getSaldo() + 50);
			}
		}
	}

	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta() {
		this.numConta = geraNumConta();
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}

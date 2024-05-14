package br.fiap.cargo;

import br.fiap.comissao.Comissao;

public enum Cargo implements Comissao{
	ATENDENTE {
		public double calcularComissao(double valor) {
			return valor * 0.10;
		}
	},
	VENDEDOR {
		public double calcularComissao(double valor) {
			return (valor * 0.15) + 5;
		}
	},
	GERENTE{
		public double calcularComissao(double valor) {
			return (valor * 0.20) + 10;
		}
	};//Fim da declaração de constantes, por isso do ;
	
	
	public String toString() {
		// Deixa apenas a primeira letra da palavra maiuscula1
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}


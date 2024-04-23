package br_circulo;

import br_formas.Formas;

public class Circulo extends Formas {
	
	public Circulo(int cX, int cY, double raio) {
		super(cY, cY, raio);
	}
	
	public double calcularArea() {	
		return  Math.PI * raio * raio;
	}
}

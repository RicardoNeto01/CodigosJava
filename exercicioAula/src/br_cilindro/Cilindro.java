package br_cilindro;

import br_formas.Formas;

public class Cilindro extends Formas{
	private double altura;
	
	public Cilindro(int cX, int cY, double raio, double altura) {
		super(cX, cY, raio);
		this.setAltura(altura);
	}

	public double calcularArea() {
		double area = 2 * Math.PI * raio * (raio + altura);
		return area;
	}
	public double calcularVolume() {
		return Math.PI * raio * raio * altura;
	}
	
	public String toString() {
		return super.toString() + "\naltura:" + this.getAltura();
	}
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}

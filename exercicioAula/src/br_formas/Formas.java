package br_formas;

public abstract class Formas {
	protected double cX;
	protected double cY;
	protected double raio;
	
	public Formas(int cX, int cY, double raio) {
		super();
		this.setcX(cX);
		this.setcY(cY);
		this.setRaio(raio);
	}
	public abstract double calcularArea();
	
	public String toString() {
		return "cx:" + cX + "\ncy:" + cY + "\nraio:" + raio  ;
	}

	public double getcX() {
		return cX;
	}

	public void setcX(double cX) {
		this.cX = cX;
	}

	public double getcY() {
		return cY;
	}

	public void setcY(double cY) {
		this.cY = cY;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	
}

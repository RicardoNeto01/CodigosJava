package treinoPoo;
public class Caneta {
	public String modelo, cor;
	private double ponta;
	protected int carga;
	private boolean tampada;
	
	public void status() {
		System.out.println("Uma caneta " + this.cor);
		System.out.println("Está tampada: " + this.tampada);
		System.out.println("Tem ponta: " + this.ponta);
		System.out.println("Carga de: " + this.carga + "%");
		System.out.println("E modelo: " + this.modelo);
	}
	
	public void rabiscar() {
		if(this.tampada) {
			System.out.println("Não dá para rabiscar");
		}else {
			System.out.println("Rabiscado!");
		}
	}
	// Funciona porque está na classe.
	public void tampar() {
		this.tampada = true;
	}
	
	public void destampar(){
		this.tampada = false;
	}
}

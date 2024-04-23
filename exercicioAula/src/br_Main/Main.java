package br_Main;

import java.util.ArrayList;
import java.util.List;

import br_cilindro.Cilindro;
import br_circulo.Circulo;
import br_formas.Formas;

public class Main {
	public static void main(String[] args) {
		
		List<Formas> lista = new ArrayList<>();
		lista.add(new Circulo(5, 5, 2)) ;
		lista.add(new Cilindro(1, 5, 5, 3));
		
		for (Formas e : lista) {
			System.out.println(e);
			System.out.println("área:" + e.calcularArea());
			if(e instanceof Cilindro) {
				Cilindro cilindro = (Cilindro) e;
				System.out.println("volume:" + cilindro.calcularVolume());
			}
		}
		
	}
}

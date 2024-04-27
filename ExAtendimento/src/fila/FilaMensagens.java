package fila;

//Ricardo Abrantes Lucas Neto RM:99947
//Mateus Vieira Vicente RM:550521
//Felipe Neves Cavalcanti RM:551619
//Felipe Coelho Assis dos Santos RM:550984

import entidades.Mensagem;

public class FilaMensagens {
		public final int N = 3;
		Mensagem dados[] = new Mensagem[N];
		int ini, fim, cont;

		public void init() {
			ini = fim = cont = 0;
		}
		public boolean isEmpty() {
			return (cont==0);
		}
		public boolean isFull() {
			return (cont==N);
		}
		public void enqueue(Mensagem mensagem) {
			if (isFull())
				System.out.println("Fila cheia");
			else {
				dados[fim] = mensagem;
				fim = (fim+1) % N;
				cont++;
			}
		}
		public Mensagem dequeue() {
			Mensagem elem = dados[ini];
			ini = (ini+1) % N;
			cont--;
			return elem;
		}
		public Mensagem first() {
			return (dados[ini]);
		}
		
	}



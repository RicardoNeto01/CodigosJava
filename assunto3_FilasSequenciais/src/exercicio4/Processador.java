package exercicio4;

import java.util.Scanner;

import filas.FilaInt;

public class Processador {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		FilaInt filaProcessos = new FilaInt();
		filaProcessos.init();
		int op;
		do {
			System.out.println(" 1- Submete processo para execucao");
			System.out.println(" 2- Executa processo (ocupa tempo do processador)");
			System.out.println(" 3- Shutdown");
			op = le.nextInt();
			switch (op) {
			case 1:
				System.out.print("PID: ");
				int pid = le.nextInt();
				filaProcessos.enqueue(pid);
				break;		
			case 2:
				if (!filaProcessos.isEmpty()) {
					pid = filaProcessos.dequeue();
					System.out.println("Processo em execucao no processador: " + pid);
					System.out.print("Processo concluiu sua execucao? (1-sim/ 2-nao): ");
					int resp = le.nextInt();
					if (resp == 1)
						System.out.println("O processo "+ pid + " foi encerrado");
					else {
						System.out.println("O processo "+ pid + " volta para fila de processos");
						filaProcessos.enqueue(pid);
					}
						
				} else 
					System.out.println("Nao ha processos na fila");
				
				break;
			case 3:
				if (filaProcessos.isEmpty())
					System.out.println("Shutdown...");
				else {
					System.out.println("Ainda ha processos na fila");
					System.out.print("Deseja encerrar assim mesmo? (1-sim/ 2-nao):");
					int resp = le.nextInt();
					if (resp == 1) {
						while (!filaProcessos.isEmpty())
							System.out.println("Encerrado processo " + filaProcessos.dequeue());
						System.out.println("Shutdown...");
					}
					else
						op = 0;
				}
				break;
			default:
				System.out.println("Opcao Invalida");
			}
		} while (op != 3);

		le.close();

	}

}

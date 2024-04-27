package aplicacao;

import java.util.Scanner;

import entidades.Mensagem;
import fila.FilaMensagens;

// Ricardo Abrantes Lucas Neto RM:99947
// Mateus Vieira Vicente RM:550521
// Felipe Neves Cavalcanti RM:551619
// Felipe Coelho Assis dos Santos RM:550984

public class AtendimentoMensagem {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();
		int op;
		
		do {
			System.out.println("0 - Encerrar programa.");
			System.out.println("1 - Recebimento e Encaminhamento de Resolução: ");
			System.out.println("2 - Atendimento de Mensagem:");
			System.out.println("3 - Recebimento e Encaminhamento de Resolução: ");
			op = teclado.nextInt();
			
			switch(op) {
			case 0:
				if(!filaReclamacao.isEmpty() || !filaResolucao.isEmpty() || !filaSugestao.isEmpty()) {
					System.out.println("Ainda há mensagens pendentes.");
					op = 4;
				}else {
					System.out.println("Encerrando atendimento...");
				}
				break;
			case 1: 
				int resp;
				String nome = null;
				String email, mensagem = null;
				System.out.println("Deseja informar seu nome? 1- Sim / 2 = Não");
				resp = teclado.nextInt();
				if(resp == 1) {
					System.out.println("Digite seu nome: ");
					nome = teclado.next();
				}else {
					nome = "Não informado.";
				}
		
				System.out.println("Email / telefone: ");
				email = teclado.next();
				
				System.out.println("Motivo do contato? 1 - reclamação // 2 - sugestão");
				int motivo = teclado.nextInt();
				if(motivo == 1) {
					System.out.println("Digite sua mensagem.");
					mensagem = teclado.next();
					Mensagem msg = new Mensagem(nome, email, motivo, mensagem);
					filaReclamacao.enqueue(msg);
				}else {
					if(motivo == 2) {
						System.out.println("Digite sua mensagem.");
						mensagem = teclado.next();
						Mensagem msg = new Mensagem(nome, email, motivo, mensagem);
						filaSugestao.enqueue(msg);
					}else {
						System.out.println("Opção inválida.");
					}
				}
			    break;
			case 2:
				int tipoAtendimento;
				Mensagem m;
				int resolucao;
				do {
					System.out.println("Qual tipo de mensagem deseja atender? 1 - Reclamação // 2 - Sugestão");
					tipoAtendimento = teclado.nextInt();
					switch(tipoAtendimento) {
						case 1:
							if(!filaReclamacao.isEmpty()) {
								m = filaReclamacao.dequeue();
								System.out.println(m);
								// Não sabiamos como fazer e demos a opção.
								System.out.println("É possivel resolver? 1 - Sim // 2 - Não");
								resolucao = teclado.nextInt();
								if(resolucao == 1) {
									System.out.println("Sua solicitação já foi resolvida. Obrigado!!!");
								}else {
									filaResolucao.enqueue(m);
									System.out.println("Você receberá sua resposta em breve.");
									tipoAtendimento = 1;
								}
							}else {
								System.out.println("Não há mensagens.");
								tipoAtendimento = 1;
							}
							
							break;
						case 2:
							if(!filaSugestao.isEmpty()) {
								m = filaSugestao.dequeue();
								System.out.println(m);
								// Não sabiamos como fazer e demos a opção.
								System.out.println("É possivel resolver? 1 - Sim // 2 - Não");
								resolucao = teclado.nextInt();
								if(resolucao == 1) {
									System.out.println("Sua solicitação já foi resolvida. Obrigado!!!");
								}else {
									filaResolucao.enqueue(m);
									System.out.println("Você receberá sua resposta em breve.");
									tipoAtendimento = 2;
								}
							}else {
								System.out.println("Não há mensagens.");
								tipoAtendimento = 2;
							}
							break;
							default:
								System.out.println("Opção inválida.");
							}
				}while(tipoAtendimento>2);
				break;
			case 3:
				if(!filaResolucao.isEmpty()) {
					Mensagem r = filaResolucao.dequeue();
					System.out.println(r);
					System.out.println("Sua solicitação já foi resolvida pelo setor responsável. Obrigado!!!");
				}else {
					System.out.println("Não há mensagens para resolver.");
				}
				break;
			default:
				System.out.println("Opção Inválida!!");
			}
		}while(op!=0);
		
		teclado.close();
	}
}

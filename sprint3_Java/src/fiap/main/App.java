package fiap.main;

import java.util.Scanner;

import fiap.connections.ProdutoDAO;
import fiap.connections.RevendedoraDAO;
import fiap.connections.VendaDAO;
import fiap.objects.Produto;
import fiap.objects.Revendedora;
import fiap.objects.Venda;

public class App {
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		
		int opcao = 0;
		
		do {
			System.out.println("---- Bem vindo ao Natura Dash ----");
			System.out.println("Escolha uma Aba: ");
			System.out.println("0 - SAIR");
			System.out.println("1 - Revendedoras");
			System.out.println("2 - Produtos");
			System.out.println("3 - Vendas");
			opcao = enter.nextInt();
			switch(opcao) {
			case 0:
				System.out.println("Obrigado por usar nosso sistema!");
				break;
			case 1:
				revendedoras();
				break;
			case 2:
				produtos();
				break;
			case 3:
				vendas();
				break;
				default:
					System.out.println("Opção Inválida.");
			}
		}while(opcao != 0);
	}
	
	public static void revendedoras() {
		Revendedora revendedora;
		RevendedoraDAO revendedoraDAO = new RevendedoraDAO();
		Scanner enter = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("---- Bem vindo a área de Revendedoras ----");
			System.out.println("O que deseja fazer?");
			System.out.println("1 - inserir revendedora.");
			System.out.println("2 - remover revendedora por código.");
			System.out.println("3 - retornar.");
			opcao = enter.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Insira o nome da revendedora");
				String nome = enter.next();
				System.out.println("Insira o código da revendedora");
				int codigo = enter.nextInt();
				System.out.println("Insira o cpf da revendedora");
				String cpf = enter.next();
				System.out.println("Insira o número de celular da revendedora");
				String numero = enter.next();
				revendedoraDAO.inserir(new Revendedora(codigo, nome, cpf, numero));
				break;
			case 2:
				System.out.println(revendedoraDAO.listar()); 
				System.out.println("Qual revendedora deseja remover?");
				int codigoRemover = enter.nextInt();
				revendedoraDAO.removerPorCodigo(codigoRemover);
				System.out.println("Revendedora removida com sucesso.");
				break;
			case 3: 
				System.out.println("Retornando...");
				break;
				default:
					System.out.println("Opção inválida!");
			}
			
		}while(opcao != 3);
	}
	
	public static void produtos() {
		Scanner enter = new Scanner(System.in);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		int opcao = 0;
		
		do {
			System.out.println("---- Bem vindo a área de produtos ----");
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Inserir produto.");
			System.out.println("2 - Pesquisar produto por ID.");
			System.out.println("3 - Remover produto por ID.");
			System.out.println("4 - Atualizar valor de Cliente por ID.");
			System.out.println("5 - Listar todos os Produtos.");
			System.out.println("6 - Retornar.");
			opcao = enter.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Insira o ID do produto: ");
				int id = enter.nextInt();
				System.out.println("Insira o nome do produto: ");
				String nome = enter.next();
				System.out.println("Insira o preço de *revendedora* do produto: ");
				double pRevendedora = enter.nextDouble();
				System.out.println("Insira o preço de *cliente* do produto: ");
				double pCliente = enter.nextDouble();
				produtoDAO.inserir(new Produto(id, nome, pRevendedora, pCliente));
				System.out.println("Produto adicionado com sucesso.");
				break;
			case 2:
				System.out.println("Insira o ID do produto que quer pesquisar: ");
				int idPesquisa = enter.nextInt();
				System.out.println("Resultado da pesquisa:\n");
				System.out.println(produtoDAO.pesquisarPorId(idPesquisa));
				break;
			case 3:
				System.out.println("Insira o ID do produto que quer remover: ");
				int idRemover = enter.nextInt();
				produtoDAO.removerPorId(idRemover);
				System.out.println("Produto removido com sucesso\n");
				break;
			case 4:
				System.out.println("Insira o ID do produto que deseja alterar o preço: ");
				int idAtualiza = enter.nextInt();
				System.out.println("Qual valor deseja colocar? ");
				double novoValor = enter.nextDouble();
				produtoDAO.alterarCusto(idAtualiza, novoValor);
				System.out.println("Preço alterado com sucesso.");
				break;
			case 5:
				System.out.println("---- Lista de Produtos ----\n");
				System.out.println(produtoDAO.listar());
				break;
			case 6:
				System.out.println("Retornando...");
				break;
				default:
					System.out.println("Opção inválida!");
			}
		}while(opcao != 6);
	}
	
	public static void vendas() {
		Scanner enter = new Scanner(System.in);
		
		int opcao = 0;
		VendaDAO vendaDAO = new VendaDAO();
		do {
			System.out.println("---- Bem vindo a área de Vendas ----");
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Adicionar venda.");
			System.out.println("2 - Remover venda.");
			System.out.println("3 - Retornar.");
			opcao = enter.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Insira o ID da venda: ");
				int idVenda = enter.nextInt();
				System.out.println("Insira o ID da Revendedora responsável pela venda: ");
				int idRevendedora = enter.nextInt();
				System.out.println("ID do produto vendido: ");
				int idProdutoVendido = enter.nextInt();
				System.out.println("Quantidade de produtos vendidos: ");
				int quantidade = enter.nextInt();
				Venda venda = new Venda(idVenda, new Revendedora(idRevendedora), new Produto(idProdutoVendido), quantidade);
				vendaDAO.inserir(venda);
				System.out.println("Venda inserida com sucesso.\n");
				break;
			case 2:
				System.out.println("Digite o ID da venda que deseja remover: ");
				int idRemover = enter.nextInt();
				vendaDAO.removerPorId(idRemover);
				System.out.println("Remoção feita com sucesso\n");
				break;
			case 3:
				System.out.println("Retornando...");
				break;
			}
		}while(opcao != 3);
	}
}

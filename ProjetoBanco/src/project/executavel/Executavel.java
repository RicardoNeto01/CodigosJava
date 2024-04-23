package project.executavel;

import static java.lang.Integer.*;
import static java.lang.Double.*;
import javax.swing.JOptionPane;
import project.contas.Conta;

public class Executavel {
	public void executar() {
		
		int opcao = 0;
		Conta conta = new Conta();
		do {
			
			opcao = parseInt(JOptionPane.showInputDialog(null,"Selecione uma opção\n 1 - Abrir conta.\n 2 - Ver dados da conta.\n 3 - Sacar.\n 4 - Depositar.\n 5 - Fechar conta.\n 6 - Encerrar Atendimento.", "Bem vindo ao Banco", JOptionPane.DEFAULT_OPTION));
			
			switch (opcao) {
			//Abre conta.
			case 1:
				if(conta.getStatus()) {
					JOptionPane.showMessageDialog(null, "A conta já esta aberta.","Banco informa:", JOptionPane.DEFAULT_OPTION);;	
				}else {
					conta.setNome(JOptionPane.showInputDialog(null,"Digite seu nome:"));
					conta.setTipoConta(JOptionPane.showInputDialog(null,"Qual o tipo de conta? CC - Conta Corrente / CP - Conta poupança" ));
					conta.tipoConta();
					JOptionPane.showMessageDialog(null, "Conta aberta com sucesso.","Banco informa:", JOptionPane.DEFAULT_OPTION);
					conta.abrirConta();
				}
				break;
			//Dados da conta
			case 2:
				if(conta.getStatus()) {
					JOptionPane.showMessageDialog(null, conta.getDados(),"Banco informa:", JOptionPane.DEFAULT_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "A conta está fechada.", "Banco informa", JOptionPane.ERROR_MESSAGE);
				}
				break;
			//Sacar
			case 3:
				if(conta.getStatus()) {
					double valor = parseDouble(JOptionPane.showInputDialog(null,"Quanto deseja sacar?"));
					if(valor>conta.getSaldo()) {
						JOptionPane.showMessageDialog(null, "Não é possível sacar\n Saldo Insuficiente!", "Banco informa:", JOptionPane.ERROR_MESSAGE);
					}else {
						conta.sacar(valor);
						JOptionPane.showMessageDialog(null, "Você sacou R$" + valor + "!", "Banco informa:", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "A conta está fechada.", "Banco informa", JOptionPane.ERROR_MESSAGE);
				}
				break;
			//Deposita
			case 4:
				if(conta.getStatus()) {
					double valor = parseDouble(JOptionPane.showInputDialog(null, "Quanto deseja depositar?"));
					conta.depositar(valor);
					JOptionPane.showMessageDialog(null, "Você depositou R$" + valor + "!", "Banco informa:", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "A conta está fechada.", "Banco informa", JOptionPane.ERROR_MESSAGE);
				}
				break;
			//Fecha conta.
			case 5:
				if(!conta.getStatus()) {
					JOptionPane.showMessageDialog(null, "A conta já está fechada.");
				}else {
					if(conta.verificaSaldo()) {
						JOptionPane.showMessageDialog(null, "Não é possível fechar sua conta\n Você possui R$" + conta.getSaldo() + " na conta", "Banco informa:", JOptionPane.ERROR_MESSAGE);
					}else {
						conta.fecharConta();
						JOptionPane.showMessageDialog(null, "Você fechou sua conta.", "Banco informa:", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				default: JOptionPane.showMessageDialog(null, "Obrigado pela preferencia!","Banco", JOptionPane.INFORMATION_MESSAGE);
			}
		} while(opcao != 6);
	
	}
	
}

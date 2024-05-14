package br.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.fiap.cargo.Cargo;
import br.fiap.funcionario.Funcionario;
import br.fiap.venda.Venda;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Main {
	public static void main(String[] args) {
		
		List<Venda> lista = new ArrayList<>();
		/* String[] listaCargo = {"Atendente", "Vendedor", "Gerente"}; */
		
		String nome;
		double salario, valorVendas;
		
		//Usado para pegar um vetor do tipo cargo, da enum.
		JComboBox<Cargo> combo = new JComboBox<>(Cargo.values());
		Cargo cargo;
		
		for(int i = 0; i < 4; i++) {
			nome = showInputDialog(null, "Digite seu nome");
			salario = parseDouble(showInputDialog(null, "Digite seu salário"));
			showMessageDialog(null, combo, "Cargo do funcionário",INFORMATION_MESSAGE);
			cargo = (Cargo)combo.getSelectedItem();
			valorVendas = parseDouble(showInputDialog(null, "Valor das vendas"));
			
			Funcionario funcionario = new Funcionario(nome, salario, cargo);
			lista.add(new Venda(funcionario, valorVendas));
			
			showMessageDialog(null, funcionario.getNome() + "\n" +cargo.calcularComissao(valorVendas));
		}
		
		
		
		
	}
}

package fiap.objects;

public class Produto {
	private String nome;
	private int id;
	private double precoRevendedora;
	private double precoCliente;

	public Produto(int id, String nome,  double precoRevendora, double precoCliente) {
		this.setNome(nome);
		this.setId(id);
		this.setPrecoRevendedora(precoRevendora);
		this.setPrecoCliente(precoCliente);
	}
	public Produto(int id) {
		this.setId(id);
	}
	public String toString() {
		return "Nome do produto: " + this.getNome() + "\nID do produto: " + this.getId() + "\nPreço para a revendedora: " + this.getPrecoRevendedora() + "R$" + "\nPreço para o cliente: " + this.getPrecoCliente() + "R$\n";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoRevendedora() {
		return precoRevendedora;
	}
	public void setPrecoRevendedora(double precoRevendedora) {
		this.precoRevendedora = precoRevendedora;
	}
	public double getPrecoCliente() {
		return precoCliente;
	}
	public void setPrecoCliente(double precoCliente) {
		this.precoCliente = precoCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

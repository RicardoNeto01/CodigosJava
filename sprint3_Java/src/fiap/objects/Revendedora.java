package fiap.objects;

public class Revendedora {
	private String nome;
	private String cpf;
	private int codigoRevendedora;
	private String numCelular;
	
	public Revendedora(int codigoRevendedora, String nome, String cpf,  String numCelular) {
		this.setCodigoRevendedora(codigoRevendedora);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setNumCelular(numCelular);
	}
	public Revendedora (int codigoRevendedora) {
		this.setCodigoRevendedora(codigoRevendedora);
	}
	public String toString() {
		return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nCódigo de Revendedora: " + this.getCodigoRevendedora() + "\nNúmero de Celular:+55" + this.getNumCelular();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCodigoRevendedora() {
		return codigoRevendedora;
	}
	public void setCodigoRevendedora(int codigoRevendedora) {
		this.codigoRevendedora = codigoRevendedora;
	}
	public String getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
}	

package entidades;

//Ricardo Abrantes Lucas Neto RM:99947
//Mateus Vieira Vicente RM:550521
//Felipe Neves Cavalcanti RM:551619
//Felipe Coelho Assis dos Santos RM:550984

public class Mensagem {
	private String nome;
	private String email;
	private int motivo;
	private String mensagem;
	
	public Mensagem(String nome, String email, int motivo, String mensagem) {
		this.setNome(nome);
		this.setEmail(email);
		this.setMotivo(motivo);
		this.setMensagem(mensagem);
	}
	
	public String toString() {
		return "Nome:" + this.getNome() + "\nEmail / telefone: " + this.getEmail() + "\nMotivo: " + this.getMotivo() + "\nMensagem: " + this.getMensagem();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMotivo() {
		return motivo;
	}
	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}

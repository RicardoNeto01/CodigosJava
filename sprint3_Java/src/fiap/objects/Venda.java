package fiap.objects;

public class Venda {
	private Revendedora revendedora;
	private Produto produto;
	private int id;
	private double lucro;
	private int quantidade;
	
	public Venda(int id, Revendedora revendedora,Produto produto, int quantidade) {
		this.setId(id);
		this.setRevendedora(revendedora);
		this.setProduto(produto);
		this.setQuantidade(quantidade);
	}
	
	public double calcularLucro(double valorCliente, double valorRevendedora) {
		return valorCliente - valorRevendedora;
	}
	
	public Revendedora getRevendedora() {
		return revendedora;
	}
	public void setRevendedora(Revendedora revendedora) {
		this.revendedora = revendedora;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}

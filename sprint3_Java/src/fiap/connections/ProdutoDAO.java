package fiap.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fiap.objects.Produto;

public class ProdutoDAO {
	private String sql;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void inserir(Produto produto) {
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "INSERT INTO Natura_produto values (?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getPrecoRevendedora());
			ps.setDouble(4, produto.getPrecoCliente());
			ps.execute();
		}catch(SQLException e){
			System.out.println("Erro ao inserir produto\n" + e);
		}
	}
	public Produto pesquisarPorId(int id) {
		Produto produto = null;
		
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "SELECT * FROM Natura_produto WHERE Id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				produto = new Produto(id, rs.getString("nome"),rs.getDouble("preco_revendedora"),rs.getDouble("preco_cliente"));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar produto\n" + e);
		}
		return produto;
	}
	
	public void removerPorId(int id) {
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "DELETE FROM Natura_produto WHERE id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao remover produto.\n" + e);
		}
	}
	
	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<Produto>();
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "SELECT * FROM Natura_produto";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco_revendedora"), rs.getDouble("preco_cliente")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar os produtos.\n" + e);
		}
		
		return lista;
	}
	
	public void alterarCusto(int id, double valor) {
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "UPDATE Natura_produto SET preco_cliente = ? where id = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, valor);
			ps.setInt(2, id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao alterar valor do produto.\n" + e);
		}	
	}
}

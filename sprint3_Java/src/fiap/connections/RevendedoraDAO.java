package fiap.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fiap.objects.Revendedora;


public class RevendedoraDAO {
	private String sql;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public void inserir(Revendedora revendedora) {
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "INSERT INTO Natura_Revendedora values (?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, revendedora.getCodigoRevendedora());
			ps.setString(2, revendedora.getNome());
			ps.setString(3, revendedora.getCpf());
			ps.setString(4, revendedora.getNumCelular());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao inserir revendedora\n" + e);
		}
	}
	
	public void removerPorCodigo(int codigo) {
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "DELETE FROM Natura_Revendedora WHERE codigo_revendedora = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.execute();
		}catch (SQLException e) {
			System.out.println("Erro ao remover revendedora\n" + e);
		}
	}
	
	public List<Revendedora> listar() {
		List<Revendedora> lista = new ArrayList<Revendedora>();
		connection = ConnectionFactory.getInstance().getConnection();
		sql = "SELECT * FROM Natura_Revendedora";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Revendedora(rs.getInt("codigo_revendedora"),rs.getString("nome"), rs.getString("cpf"), rs.getString("num_celular")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar os produtos.\n" + e);
		}
		
		return lista;
	}
}

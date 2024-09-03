package fiap.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fiap.objects.Venda;

public class VendaDAO {
    private String sql;
    private Connection connection;
    private PreparedStatement ps;

    public void inserir(Venda venda) {
        connection = ConnectionFactory.getInstance().getConnection();
        sql = "INSERT INTO Natura_venda VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, venda.getId());
            ps.setInt(2, venda.getRevendedora().getCodigoRevendedora());
            ps.setDouble(3, venda.getProduto().getId());
            ps.setInt(4, venda.getQuantidade());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir venda\n" + e);
        } 
    }


    public void removerPorId(int id) {
        connection = ConnectionFactory.getInstance().getConnection();
        sql = "DELETE FROM Natura_venda WHERE id_venda = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao remover venda\n" + e);
        }
    }

   
}

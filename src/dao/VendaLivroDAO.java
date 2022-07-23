package dao;

import conexao.Conexao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.VendaLivro;

/**
 *
 * @author 180900411
 */
public class VendaLivroDAO implements InterfaceDAO<VendaLivro> 
{
    @Override
    public void add(VendaLivro pVO) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        try {
            String sql;
            sql = "INSERT INTO vendaLivro VALUES (null, "
                    + pVO.getIdCliente() + ", "
                    + pVO.getIdLivro() + ", "
                    + pVO.getQtd() + ", "
                    + pVO.getSubTotal() + ", '"
                    + pVO.getDataVenda() + "');";
            
            
            System.out.println(":1 " + sql);
            
            statement.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir a venda do livro no sistema.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public VendaLivro getById(int id) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        VendaLivro vendaLivro = new VendaLivro();

        try {
            String sql;
            sql = "SELECT * FROM vendalivro WHERE idVendaLivro = " + id;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                vendaLivro.setIdVendaLivro(rs.getInt("idVendaLivro"));
                vendaLivro.setIdCliente(rs.getInt("idCliente"));
                vendaLivro.setIdLivro(rs.getInt("idLivro"));
                vendaLivro.setQtd(rs.getInt("quantidadeVendida"));
                vendaLivro.setSubTotal(rs.getDouble("subTotal"));
                vendaLivro.setDataVenda(rs.getDate("dateVendaLivro"));
            }
        } catch (SQLException e) {
            throw new SQLException("Venda do livro não encontrada.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return vendaLivro;
    }

    @Override
    public VendaLivro getByDoc(String doc) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        VendaLivro vendaLivro = new VendaLivro();

        try {
            String sql;
            sql = "SELECT * FROM vendalivro WHERE idVendaLivro = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                vendaLivro.setIdVendaLivro(rs.getInt("idVendaLivro"));
                vendaLivro.setIdCliente(rs.getInt("idCliente"));
                vendaLivro.setIdLivro(rs.getInt("idLivro"));
                vendaLivro.setQtd(rs.getInt("quantidadeVendida"));
                vendaLivro.setSubTotal(rs.getDouble("subTotal"));
                vendaLivro.setDataVenda(rs.getDate("dateVendaLivro"));
            }
        } catch (SQLException e) {
            throw new SQLException("Venda do livro não encontrada.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return vendaLivro;
    }

    @Override
    public ArrayList<VendaLivro> getAll() throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        try {
            String sql;
            sql = "SELECT * FROM vendaLivro";

            ResultSet rs = statement.executeQuery(sql);

            ArrayList<VendaLivro> listaVendaLivro = new ArrayList<>();

            while (rs.next()) {
                VendaLivro vendaLivro = new VendaLivro();
                
                vendaLivro.setIdVendaLivro(rs.getInt("idVendaLivro"));
                vendaLivro.setIdCliente(rs.getInt("idCliente"));
                vendaLivro.setIdLivro(rs.getInt("idLivro"));
                vendaLivro.setQtd(rs.getInt("qtd"));
                vendaLivro.setSubTotal(rs.getDouble("subTotal"));
                vendaLivro.setDataVenda(rs.getDate("dataCompra"));

                listaVendaLivro.add(vendaLivro);
            }
            System.out.println("get all ");
            return listaVendaLivro;
        } catch (SQLException e) {
            throw new SQLException("Venda do livro não encontrada.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public boolean updateFields(VendaLivro pVO) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        int executou = 0;

        try {
            String sql;
            sql = "UPDATE vendaLivro SET "
                    + "idCliente = " + pVO.getIdCliente() + ", "
                    + "idLivro = " + pVO.getIdLivro() + ", "
                    + "quantidade = " + pVO.getQtd() + ", "
                    + "subTotal = " + pVO.getSubTotal() + ", "
                    + "dataVenda = '" + pVO.getDataVenda() + "' "
                    + "WHERE idVendaLivro = " + pVO.getIdVendaLivro();

            executou = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar a venda do livro.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        if (executou == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteOne(int id) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        boolean executou = false;

        try {
            String sql;
            sql = "DELETE FROM vendalivro WHERE idVendaLivro = " + id;

            executou = statement.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a venda do livro.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return executou;
    }

    @Override
    public boolean deleteAll() throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        boolean executou = false;

        try {
            String sql;
            sql = "DELETE FROM vendalivro";

            executou = statement.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a venda do livro.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return executou;
    }
}

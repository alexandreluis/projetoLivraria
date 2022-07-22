package dao;

import conexao.Conexao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author 180900411
 */
public class EditoraDAO implements InterfaceDAO<Editora> {

    @Override
    public void add(Editora pVO) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        try {
            String sql;
            sql = "INSERT INTO editora VALUES (null, '"
                    + pVO.getNmEditora() + "', '"
                    + pVO.getEndereco() + "', '"
                    + pVO.getTelefone() + "', '"
                    + pVO.getGerente() + "');";

            statement.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Editora.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public Editora getById(int id) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Editora editora = new Editora();

        try {
            String sql;
            sql = "SELECT * FROM editora WHERE idEditora = " + id;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setNmEditora(rs.getString("nmEditora"));
                editora.setEndereco(rs.getString("endereco"));
                editora.setTelefone(rs.getString("telefone"));
                editora.setGerente(rs.getString("gerente"));
            }
        } catch (SQLException e) {
            throw new SQLException("Editora não existe.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return editora;
    }

    @Override
    public Editora getByDoc(String doc) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Editora editora = new Editora();

        try {
            String sql;
            sql = "SELECT * FROM editora WHERE idEditora = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setNmEditora(rs.getString("nomeEditora"));
                editora.setEndereco(rs.getString("enderecoEditora"));
                editora.setTelefone(rs.getString("telefoneEditora"));
                editora.setGerente(rs.getString("gerenteEditora"));
            }
        } catch (SQLException e) {
            throw new SQLException("Editora não existe.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return editora;
    }

    @Override
    public ArrayList<Editora> getAll() throws SQLException 
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        try {
            String sql;
            sql = "SELECT * FROM editora";

            ResultSet rs = statement.executeQuery(sql);

            ArrayList<Editora> listaDeEditoras = new ArrayList<>();

            while (rs.next()) {
                Editora editora = new Editora();

                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setNmEditora(rs.getString("nmEditora"));
                editora.setEndereco(rs.getString("endereco"));
                editora.setTelefone(rs.getString("telefone"));
                editora.setGerente(rs.getString("gerente"));

                listaDeEditoras.add(editora);
            }

            return listaDeEditoras;
        } catch (SQLException e) {
            throw new SQLException("Não existem Editoras.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public boolean updateFields(Editora pVO) throws SQLException {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        int executou = 0;
        
        try {
            String sql;
            sql = "UPDATE editora SET "
                    + "nomeEditora = '" + pVO.getNmEditora() + "', "
                    + "enderecoEditora = '" + pVO.getEndereco() + "', "
                    + "telefoneEditora = '" + pVO.getTelefone() + "', "
                    + "gerenteEditora = '" + pVO.getGerente() + " "
                    + "WHERE idEditora = " + pVO.getIdEditora();
            executou = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Pessoa.\n" + e.getMessage());
        } finally {
            conn.close();
            statement.close();
        }

        if (executou == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteOne(int id) throws SQLException 
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM editora WHERE idEditora = " + id;
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar cliente.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }

    @Override
    public boolean deleteAll() throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM editora";
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar clientes.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }
}
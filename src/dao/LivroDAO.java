package dao;

import conexao.Conexao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 180900411
 */
public class LivroDAO implements InterfaceDAO<Livro> {

    @Override
    public void add(Livro pVO) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        try {
            String sql;
            sql = "INSERT INTO livro VALUES (null, '"
                    + pVO.getTitulo() + "', '"
                    + pVO.getAutor() + "', '"
                    + pVO.getAssunto() + "', '"
                    + pVO.getIsbn() + "', "
                    + pVO.getEstoque() + ", "
                    + pVO.getPreco() + ", "
                    + pVO.getIdEditora() + ");";
            System.out.println("::::"  + pVO.getIdEditora());
            System.out.println(" sql " + sql);
            statement.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir o livro.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public Livro getById(int id) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Livro livro = new Livro();

        try {
            String sql;
            sql = "SELECT * FROM livro WHERE idLivro = " + id;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("tituloLivro"));
                livro.setAutor(rs.getString("autorLivro"));
                livro.setAssunto(rs.getString("assuntoLivro"));
                livro.setIsbn(rs.getString("isbnLivro"));
                livro.setEstoque(rs.getInt("estoqueLivro"));
                livro.setPreco(rs.getFloat("precoLivro"));
                livro.setIdLivro(rs.getInt("idLivro"));
            }
        } catch (SQLException e) {
            throw new SQLException("Livro não encontrado.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return livro;
    }

    @Override
    public Livro getByDoc(String doc) throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Livro livro = new Livro();

        try {
            String sql;
            sql = "SELECT * FROM livro WHERE idLivro = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("tituloLivro"));
                livro.setAutor(rs.getString("autorLivro"));
                livro.setAssunto(rs.getString("assuntoLivro"));
                livro.setIsbn(rs.getString("isbnLivro"));
                livro.setEstoque(rs.getInt("estoqueLivro"));
                livro.setPreco(rs.getFloat("precoLivro"));
                livro.setIdLivro(rs.getInt("idLivro"));
            }
        } catch (SQLException e) {
            throw new SQLException("Livro não encontrado.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }

        return livro;
    }

    @Override
    public ArrayList<Livro> getAll() throws SQLException {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        try {
            String sql;
            sql = "SELECT * FROM livro";

            ResultSet rs = statement.executeQuery(sql);

            ArrayList<Livro> listaDeLivro = new ArrayList<>();

            while (rs.next()) 
            {
                Livro livro = new Livro();

                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAssunto(rs.getString("assunto"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setEstoque(rs.getInt("estoque"));
                livro.setPreco(rs.getFloat("preco"));
                livro.setIdEditora(rs.getInt("idEditora"));

                listaDeLivro.add(livro);
            }

            return listaDeLivro;
        } catch (SQLException e) {
            throw new SQLException("Livro não encontrado.\n" + e.getMessage());
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public boolean updateFields(Livro pVO) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        int executou = 0;
        
        try
        {
            String sql;
            sql = "UPDATE livro SET "
                    + "tituloLivro = '" + pVO.getTitulo() + "', "
                    + "autorLivro = '" + pVO.getAutor() + "', "
                    + "assuntoLivro = '" + pVO.getAssunto() + "', "
                    + "isbnLivro = '" + pVO.getIsbn() + "', "
                    + "estoqueLivro = " + pVO.getEstoque() + ", "
                    + "precoLivro = " + pVO.getPreco() + ", "
                    + "idEditoraLivro = " + pVO.getIdEditora()+ " "
                    + "WHERE idLivro = " + pVO.getIdLivro();
            
            executou = statement.executeUpdate(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao atualizar o livro.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        if(executou == 1)
        {
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
            sql = "DELETE FROM livro WHERE idLivro = " + id;
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar livro.\n" + e.getMessage());
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
            sql = "DELETE FROM livro";
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar livros.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }
}
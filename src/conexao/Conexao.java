package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author 180900411
 */
public class Conexao 
{
    private static String url = "jdbc:mysql://localhost:3306/livrarian211";
    
    private static String user = "root";
    
    private static String password = "";
    
    public static Connection getConexao() throws SQLException
    {
        Connection conn = null;
        
        try
        {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao conectar ao banco.\n" + e.getMessage());
        }
        
        return conn;
    }
}

package dao;

/**
 *
 * @author 180900411
 */
public class DAOFactory 
{
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static EditoraDAO editoraDAO = new EditoraDAO();
    private static LivroDAO livroDAO = new LivroDAO();
    private static VendaLivroDAO vendaLivroDAO = new VendaLivroDAO();
    
    public static ClienteDAO getClienteDAO()
    {
        return clienteDAO;
    }
    
    public static EditoraDAO getEditoraDAO()
    {
        return editoraDAO;
    }
    
    public static LivroDAO getLivroDAO()
    {
        return livroDAO;
    }
    
    public static VendaLivroDAO getVendaLivroDAO()
    {
        return vendaLivroDAO;
    }
}
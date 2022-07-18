
package Services;

import dao.EditoraDAO;
import model.Editora;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 180900411
 */
public class EditoraServices
{
    public void addEditora(Editora pVO) throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        editoraDAO.add(pVO);
    }
    
    public Editora getById(int idEditora) throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.getById(idEditora);
    }
    
    public Editora getByDoc(String documentOfEditor) throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.getByDoc(documentOfEditor);
    }
    
    public ArrayList<Editora> getAll() throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.getAll();
    }
    
    public boolean updateFieldsOfEditora(Editora pVO) throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.updateFields(pVO);
    }
    
    public boolean deleteOneEditora(int idEditora) throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.deleteOne(idEditora);
    }
    
    public boolean deleteAll() throws SQLException
    {
        EditoraDAO editoraDAO = DAOFactory.getEditoraDAO();
        return editoraDAO.deleteAll();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import dao.DAOFactory;
import dao.EditoraDAO;
import dao.VendaLivroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editora;
import model.VendaLivro;

/**
 *
 * @author 180900411
 */
public class VendaLivroServices 
{
    public void addEditora(VendaLivro pVO) throws SQLException
    {
        VendaLivroDAO vendaLivro = DAOFactory.getVendaLivroDAO();
        vendaLivro.add(pVO);
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
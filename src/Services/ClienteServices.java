package Services;

import model.Cliente;
import dao.ClienteDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 180900411
 */
public class ClienteServices 
{
    public void addCliente(Cliente pVO) throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        clienteDAO.add(pVO);
    }
    
    public Cliente getById(int idCliente) throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.getById(idCliente);
    }
    
    public Cliente getByDoc(String documentOfClient) throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.getByDoc(documentOfClient);
    }
    
    public ArrayList<Cliente> getAll() throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.getAll();
    }
    
    public boolean updateFieldsOfClient(Cliente pVO) throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.updateFields(pVO);
    }
    
    public boolean deleteOneClient(int idClient) throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.deleteOne(idClient);
    }
    
    public boolean deleteAll() throws SQLException
    {
        ClienteDAO clienteDAO = DAOFactory.getClienteDAO();
        return clienteDAO.deleteAll();
    }
}
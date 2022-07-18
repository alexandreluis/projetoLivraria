package Services;

import dao.DAOFactory;
import dao.LivroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 180900411
 */
public class LivroServices {

    public void addLivro(Livro pVO) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        livroDAO.add(pVO);
    }

    public Livro getById(int idLivro) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.getById(idLivro);
    }

    public Livro getByDoc(String docOfLivro) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.getByDoc(docOfLivro);
    }

    public ArrayList<Livro> getAll() throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.getAll();
    }

    public boolean updateFieldsOfCliente(Livro pVO) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.updateFields(pVO);
    }

    public boolean deleteOneBook(int idBook) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.deleteOne(idBook);
    }
    
    public boolean deleteAll(int idBook) throws SQLException {
        LivroDAO livroDAO = DAOFactory.getLivroDAO();
        return livroDAO.deleteAll();
    }
}
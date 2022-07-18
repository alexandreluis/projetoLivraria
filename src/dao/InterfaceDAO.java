package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 180900411
 */
public interface InterfaceDAO<T> 
{

    public void add(T pVO) throws SQLException;

    public T getById(int id) throws SQLException;

    public T getByDoc(String doc) throws SQLException;

    public ArrayList<T> getAll() throws SQLException;

    public boolean updateFields(T pVO) throws SQLException;

    public boolean deleteOne(int id) throws SQLException;

    public boolean deleteAll() throws SQLException;
}
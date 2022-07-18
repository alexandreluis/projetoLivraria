
package Services;

import dao.ClienteDAO;

/**
 *
 * @author 180900411
 */
public class ServicesFactory 
{
    private static ClienteServices clienteServices = new ClienteServices();
    private static EditoraServices editoraServices = new EditoraServices();
    private static LivroServices livroServices = new LivroServices();
            
    public static ClienteServices getClienteServices()
    {
        return clienteServices;
    }
    
    public static EditoraServices getEditoraServices()
    {
        return editoraServices;
    } 
    
    public static LivroServices getLivroServices()
    {
        return livroServices;
    }
}
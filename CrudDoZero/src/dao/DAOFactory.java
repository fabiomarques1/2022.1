package dao;

public class DAOFactory {
    
    public static ContatoDAO criarContatoDAO() {
        return new ContatoDAOJDBC();
    }
    
}

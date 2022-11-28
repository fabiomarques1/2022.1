package dao;

import java.util.List;
import modelo.Contato;

public interface ContatoDAO {
    
    public int inserir(Contato contato);
    public int editar(Contato contato);
    public int apagar(int id);
    public List<Contato> listar();
    public Contato encontrar(int id);
    
}

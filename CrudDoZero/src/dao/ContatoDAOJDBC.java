package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Contato;

public class ContatoDAOJDBC implements ContatoDAO {
    
    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;

    @Override
    public int inserir(Contato contato) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO contatos(nome, idade, datacadastro) ")
                .append("VALUES (?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(insert);
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setDate(3, new Date(contato.getDataCadastro().getTime()));
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return linha;
    }

    @Override
    public int editar(Contato contato) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE contatos SET ")
                .append("nome = ?,")
                .append("idade = ? ")
                .append("WHERE id = ?");
        
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(update);
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setInt(3, contato.getId());
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public int apagar(int id) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM contatos ")
                .append("WHERE id = ?");
        
        String delete = sqlBuilder.toString();
        int linha = 0;
        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(delete);
            sql.setInt(1, id);
            linha = sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public List<Contato> listar() {
        
        String select = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            rset = sql.executeQuery();

            while (rset.next()) {

                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("datacadastro"));

                contatos.add(contato);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return contatos;
    }

    @Override
    public Contato encontrar(int id) {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT * FROM contatos ")
                .append("WHERE id = ?");
        
        String select = sqlBuilder.toString();

        Contato contato = null;

        try {
            conexao = ConexaoMySQL.getConexao();

            sql = (PreparedStatement) conexao.prepareStatement(select);

            sql.setInt(1, id);

            rset = sql.executeQuery();

            while (rset.next()) {

                contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("datacadastro"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return contato;
    }
    
    private void fecharConexao() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (sql != null) {
                sql.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

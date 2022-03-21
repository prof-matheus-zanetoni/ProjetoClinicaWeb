package dao;

import java.sql.Connection;
import java.sql.SQLException;
import utils.Conexao;

public class AtividadePrincipalDAO {
    
    private Connection conexao;
    
    public AtividadePrincipalDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }
}
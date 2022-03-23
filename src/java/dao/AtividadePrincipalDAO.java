package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.AtividadePrincipal;
import utils.Conexao;

public class AtividadePrincipalDAO implements DAOGenerica {

    private Connection conexao;

    public AtividadePrincipalDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        AtividadePrincipal atividadePrincipal = (AtividadePrincipal) objeto;
        String sql = "call cadastrarAtividadePrincipal(?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, atividadePrincipal.getCodigoAtividadePrincipal());
            stmt.setString(2, atividadePrincipal.getDescricaoAtividadePrincipal());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar atividade principal");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

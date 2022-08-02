package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Medico;
import utils.Conexao;

public class MedicoDAO implements DAOGenerica {
    
    private Connection conexao;

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "call cadastrarMedico(?,?,?,?,?,?,?)";
        Medico medico = (Medico) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, medico.getCodigoPessoa());
            stmt.setString(2, medico.getNomePessoa());
            stmt.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(medico.getDataNascimentoPessoa()).getTime()));
            stmt.setString(4, medico.getCpfPessoa());
            stmt.setString(5, medico.getSenhaPessoa());
            stmt.setString(6, medico.getCrmMedico());
            stmt.setBoolean(7, medico.isStatusMedico());
            stmt.execute();
        } catch (SQLException | ParseException ex) {
            throw new SQLException("Erro ao gravar médico");
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
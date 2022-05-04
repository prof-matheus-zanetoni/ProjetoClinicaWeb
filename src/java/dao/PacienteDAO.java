package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Paciente;
import utils.Conexao;

public class PacienteDAO implements DAOGenerica {

    private Connection conexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        Paciente paciente = (Paciente) objeto;
        String sql = "call cadastrarPaciente(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, paciente.getCodigoPessoa());
            stmt.setString(2, paciente.getNomePessoa());
            stmt.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(paciente.getDataNascimentoPessoa()).getTime()));
            stmt.setString(4, paciente.getCpfPessoa());
            stmt.setString(5, paciente.getSenhaPessoa());
            stmt.setString(6, paciente.getNumeroCartaoSusPaciente());
            stmt.setBoolean(7, paciente.isStatusPaciente());
            stmt.execute();
        } catch (SQLException | ParseException ex) {
            throw new SQLException("Erro ao gravar paciente");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from paciente pa inner join pessoa pe on pa.codigopaciente = pe.codigopessoa where pe.codigopessoa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //paciente = new Paciente();
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar paciente");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return paciente;
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
package controller;

import dao.AtividadePrincipalDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AtividadePrincipal;

@WebServlet(name = "CadastrarAtividadePrincipal", urlPatterns = {"/CadastrarAtividadePrincipal"})
public class CadastrarAtividadePrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            int codigoAtividadePrincipal = request.getParameter("codigoAtividadePrincipal").isEmpty() ? 0 : Integer.parseInt(request.getParameter("codigoAtividadePrincipal"));

            String descricaoAtividadePrincipal = request.getParameter("descricaoAtividadePrincipal");

            AtividadePrincipal atividadePrincipal = new AtividadePrincipal(codigoAtividadePrincipal, descricaoAtividadePrincipal);

            AtividadePrincipalDAO atividadePrincipalDAO = new AtividadePrincipalDAO();

            atividadePrincipalDAO.cadastrar(atividadePrincipal);

            request.setAttribute("mensagem", "Gravado com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarAtividadePrincipal").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


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

@WebServlet(name = "ConsultarAtividadePrincipal", urlPatterns = {"/ConsultarAtividadePrincipal"})
public class ConsultarAtividadePrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int codigoAtividadePrincipal = Integer.parseInt(request.getParameter("codigoAtividadePrincipal"));
            
            AtividadePrincipalDAO atividadePrincipalDAO = new AtividadePrincipalDAO();
            
            AtividadePrincipal atividadePrincipal = (AtividadePrincipal) atividadePrincipalDAO.consultar(codigoAtividadePrincipal);
        } catch(SQLException | ClassNotFoundException ex) {
            
        }
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
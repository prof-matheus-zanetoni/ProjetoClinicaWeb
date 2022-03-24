
package controller;

import dao.AtividadePrincipalDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirAtividadePrincipal", urlPatterns = {"/ExcluirAtividadePrincipal"})
public class ExcluirAtividadePrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int codigoAtividadePrincipal = Integer.parseInt(request.getParameter("codigoAtividadePrincipal"));
            
            AtividadePrincipalDao atividadePrincipalDao = new AtividadePrincipalDao();
            
            atividadePrincipalDao.excluir(codigoAtividadePrincipal);
            
            request.setAttribute("mensagem", "Excluído com sucesso");
            
        } catch(SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("listarAtividadePrincipal.jsp").forward(request, response);
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
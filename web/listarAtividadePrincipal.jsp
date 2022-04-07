<%@page import="java.util.List"%>
<%@page import="model.AtividadePrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="container-fluid">
    <table class="table">
        <thead>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
                <th colspan="2">Ações</th>
            </tr>
        </thead>
        <%
            List<AtividadePrincipal> lista
                    = (List<AtividadePrincipal>) request.getAttribute("atividadesPrincipais");
        %>
        <tbody>
            <%
                for (AtividadePrincipal atividadePrincipal : lista) {
            %>
            <tr>
                <td><%= atividadePrincipal.getCodigoAtividadePrincipal() %></td>
                <td><%= atividadePrincipal.getDescricaoAtividadePrincipal() %></td>
                
                <td><a href="ConsultarAtividadePrincipal?codigoAtividadePrincipal=
                       <%= atividadePrincipal.getCodigoAtividadePrincipal() %>" 
                       class="btn btn-info">Alterar</a></td>
                       
                <td><a href="ExcluirAtividadePrincipal?codigoAtividadePrincipal=
                       <%= atividadePrincipal.getCodigoAtividadePrincipal() %>" 
                       class="btn btn-danger">Excluir</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<jsp:include page="/rodape.jsp"/>
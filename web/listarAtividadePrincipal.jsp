<%@page import="java.util.List"%>
<%@page import="model.AtividadePrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="w-75 mx-auto">
    <h3 class="text-center">Listagem de atividades principais</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
                <th colspan="2">Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<AtividadePrincipal> lista = (List<AtividadePrincipal>) request.getAttribute("atividadesPrincipais");
            %>
        </tbody>
    </table>
</div>
<jsp:include page="/rodape.jsp"/>
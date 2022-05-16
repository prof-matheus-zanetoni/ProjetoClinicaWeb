<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h3>Cadastrar paciente</h3>
    </div>
    <div class="card-body">
        <form action="CadastrarPaciente" method="post">
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="codigoAtividadePrincipal">Código:</label>
                    <input class="form-control" type="text" id="codigoAtividadePrincipal" name="codigoAtividadePrincipal" readonly value="${atividadePrincipal.codigoAtividadePrincipal > 0 ? atividadePrincipal.codigoAtividadePrincipal : ""}"/>
                </div>
                <div class="form-group col-6">
                    <label for="descricaoAtividadePrincipal">Descrição:</label>
                    <input class="form-control" type="text" id="descricaoAtividadePrincipal" name="descricaoAtividadePrincipal" placeholder="Descrição" required value="${atividadePrincipal.descricaoAtividadePrincipal}"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="form-group col-12 text-center">
                    <button class="btn btn-success" type="submit">Gravar</button>
                    <a class="btn btn-secondary" href="ListarAtividadePrincipal">Voltar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>
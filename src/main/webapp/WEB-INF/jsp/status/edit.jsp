<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Status</title> 
	
	<%@ include file="/resources/jsp/header.jsp"%> 

</head>

<body class="text-center">

	<form action="/chamados/status/salvar" method="post" class="form-default">
		
		<%@ include file="/resources/jsp/menu.jsp"%> 
	
		<h2 class="h3 mb-3 font-weight-normal">Cadastro de Status</h2>
		
		<input type="hidden" name="status.staId" value="${ status.staId }" />
		
	
		<%@ include file="/resources/jsp/mensagem.jsp"%> 

		
		<label for="staNm"  class="col-form-label-sm"><fmt:message key="StaNm"/></label>
	    <input  id="staNm"  type="text"  class="form-control form-control-sm"  name="status.staNm"   value="${ status.staNm }" />
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/status/clear'">Limpar</button>
		 
		<c:if test="${ not empty status.staId }">
			<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/status/delete'">Excluir</button>
		</c:if>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/status/list'">Voltar</button>
	</form>
	
    <%@ include file="/resources/jsp/footer.jsp"%> 
    
</body>
</html>
	    
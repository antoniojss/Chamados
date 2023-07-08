<!DOCTYPE html>
<html>
<head>
		<title>Cadastro de Setores</title> 
        <%@ include file="/resources/jsp/header.jsp"%> 

</head>

<body class="text-center">

	<form action="/chamados/setor/salvar" method="post" class="form-default">
		<%@ include file="/resources/jsp/menu.jsp"%> 
	
		<h2 class="h3 mb-3 font-weight-normal">Cadastro de Setores</h2>
		
		<input type="hidden" name="setor.setId" value="${ setor.setId }" />
		
	
		<%@ include file="/resources/jsp/mensagem.jsp"%> 

		
		<label for="setNm"  class="col-form-label-sm"><fmt:message key="SetNm"/></label>
	    <input  id="setNm"  type="text"  class="form-control form-control-sm"  name="setor.setNm"   value="${ setor.setNm }" />
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/setor/clear'">Limpar</button>
		 
		<c:if test="${ not empty setor.setId }">
			<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/setor/delete'">Excluir</button>
		</c:if>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/setor/list'">Voltar</button>
	</form>
	
<%@ include file="/resources/jsp/footer.jsp"%> 

</body>
</html>
	    
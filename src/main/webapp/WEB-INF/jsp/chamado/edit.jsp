<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Chamados</title> 
	<%@ include file="/resources/jsp/header.jsp"%>
</head>

<body class="text-center">

	<form action="/chamados/chamado/salvar" method="post" class="form-default">
		<%@ include file="/resources/jsp/menu.jsp"%> 
	
		<h2 class="h3 mb-3 font-weight-normal">Cadastro de Chamados</h2>
		
		<input type="hidden" name="chamado.chaId" value="${ chamado.chaId }" />
	
		<%@ include file="/resources/jsp/mensagem.jsp"%>

	
		<label for="setor" 		class="col-form-label-sm"><fmt:message key="SetNm"/></label>
		<select id="chamado.setorModel.setId" class="form-control form-control-sm"	name="chamado.setorModel.setId" >
			<option value=0>SELECIONE</option>
			<c:forEach items="${setoresLst}" var="setor">
				<option value="${setor.setId}" 
					<c:if test="${ setor.setId == chamado.setorModel.setId}">Selected</c:if> >
					${setor.setNm}
				</option>		
			</c:forEach>
		</select> 
		
		<label for="chmDescricao"  class="col-form-label-sm"><fmt:message key="ChmDescricao"/></label>
	    <textarea   id="chmDescricao"   rows="3" class="form-control form-control-sm"  name="chamado.chmDescricao"><c:out value="${ chamado.chmDescricao }"/></textarea>
		
		<label for="status" 		class="col-form-label-sm"><fmt:message key="StaNm"/></label>
		<select id="chamado.statusModel.staId" class="form-control form-control-sm"	name="chamado.statusModel.staId" >
		<option value=0>SELECIONE</option>
			<c:forEach items="${statusLst}" var="status">
				<option value="${status.staId}" 
					<c:if test="${ status.staId == chamado.statusModel.staId}">Selected</c:if> >
					${status.staNm}
				</option>		
			</c:forEach>
		</select> 
		<br>
		
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/chamado/clear'">Limpar</button>
		 
		<c:if test="${ not empty chamado.chaId }">
			<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/chamado/delete'">Excluir</button>
		</c:if>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/chamado/list'">Voltar</button>
	</form>
	
<%@ include file="/resources/jsp/footer.jsp"%>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
	<title>Chamados - Acompanhamento</title> 
	<%@ include file="/resources/jsp/header.jsp"%>
</head>

<body class="text-center">

	<form action="/chamados/acompanhamento/salvar" method="post" class="form-default">
		<%@ include file="/resources/jsp/menu.jsp"%> 
	
		<h2 class="h3 mb-3 font-weight-normal">Chamados - Acompanhamento</h2>
	 
	 	<%@ include file="/resources/jsp/mensagem.jsp"%>

		<label for="chaId"   class="col-form-label-sm"><fmt:message key="ChaId"/></label>
	    <input id="chaId"    class="col-form-label-sm" name="acompanhamento.chamadoModel.chaId"  value="${ chamado.chaId }" readonly/> 
	
		<label for="status" 		class="col-form-label-sm"><fmt:message key="StaNm"/></label>
		<select id="staId" class="form-control form-control-sm"	name="acompanhamento.chamadoModel.statusModel.staId" >
		<option value=0>SELECIONE</option>
			<c:forEach items="${statusLst}" var="status">
				<option value="${status.staId}" 
					<c:if test="${ status.staId ==  chamado.statusModel.staId}">Selected</c:if> >
					${status.staNm}
				</option>		
			</c:forEach>
		</select> 
		<br>
	
		<label for="setor" 		class="col-form-label-sm"><fmt:message key="SetNm"/></label>
		<input id="setId"   class="form-control form-control-sm"  name="acompanhamento.chamado.setorModel.setId" value="${  chamado.setorModel.setNm}" readonly/> 
	
		<label for="usrNome" 		class="col-form-label-sm"><fmt:message key="UsrNome"/></label>
		<input id="usrId"   class="form-control form-control-sm"  name="acompanhamento.chamado.usuarioModel.usrId" value="${  chamado.usuarioModel.usrNome}" readonly/> 
		
		<label for="chmDescricao"  class="col-form-label-sm"><fmt:message key="ChmDescricao"/></label>
	    <textarea   id="acompanhamento.chamado.chmDescricao"   rows="3" class="form-control form-control-sm"  name="acompanhamento.chamado.chmDescricao" readonly="readonly" ><c:out value="${  chamado.chmDescricao }"/></textarea>
		
		<label for="acoDsSolucao"  class="col-form-label-sm"><fmt:message key="AcoDsSolucao"/></label>
	    <textarea   id="acoDsSolucao"   rows="3" class="form-control form-control-sm"  name="acompanhamento.acoDsSolucao"><c:out value="${ acompanhamento.acoDsSolucao }"/></textarea>
		
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/acompanhamento/clear'">Limpar</button>
		 
			<display:table name="acompanhamentoLst">
				<display:column property="usuarioModel.usrNome" titleKey="UsrNome" sortable="true"/>
				<display:column property="acoDsSolucao" titleKey="AcoDsSolucao" sortable="true"/>
				<display:column property="chamadoModel.chaId" titleKey="ChaId" sortable="true"/>
			</display:table>
		

	</form>
	
<%@ include file="/resources/jsp/footer.jsp"%>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Usuários</title> 
	<%@ include file="/resources/jsp/header.jsp"%>
</head>

<body class="text-center">

	<form action="/chamados/usuario/salvar" method="post" class="form-default">
		<%@ include file="/resources/jsp/menu.jsp"%> 
	
		<h2 class="h3 mb-3 font-weight-normal">Cadastro de Usuários</h2>
		
		<input type="hidden" name="usuario.usrId" value="${ usuario.usrId }" />
		
	
		<%@ include file="/resources/jsp/mensagem.jsp"%>
		
		<label for="usrNome"  class="col-form-label-sm"><fmt:message key="UsrNome"/></label>
	    <input  id="usrNome"  type="text"  class="form-control form-control-sm"  name="usuario.usrNome"   value="${ usuario.usrNome }" />
		
		<label for="usrEmail"    class="col-form-label-sm"><fmt:message key="UsrEmail"/></label>
	    <input  id="usrEmail"    type="email" class="form-control form-control-sm"   name="usuario.usrEmail"    value="${ usuario.usrEmail }"   />
		
		<label for="usrTelefone" class="col-form-label-sm"><fmt:message key="UsrTelefone"/></label>
	    <input  id="usrTelefone" type="tel" 	 class="form-control form-control-sm" 	 name="usuario.usrTelefone" value="${ usuario.usrTelefone }" />
	
		<label for="setor" 		class="col-form-label-sm"><fmt:message key="SetNm"/></label>
		<select id="usuario.setorModel.setId" class="form-control form-control-sm"	name="usuario.setorModel.setId" >
			<option value=0>SELECIONE</option>
			<c:forEach items="${setoresLst}" var="setor">
				<option value="${setor.setId}" 
					<c:if test="${ setor.setId == usuario.setorModel.setId}">Selected</c:if> >
					${setor.setNm}
				</option>		
			</c:forEach>
		</select> 
		
		<label for="UsrSenha" 	class="col-form-label-sm"><fmt:message key="UsrSenha"/></label>
	    <input  id="UsrSenha"  	type="password" class="form-control form-control-sm" 	 name="usuario.usrSenha" />
		
		<label for="UsrSenhaConf" 	class="col-form-label-sm"><fmt:message key="UsrSenhaConf"/></label>
	    <input  id="UsrSenhaConf"  	type="password" class="form-control form-control-sm" 	 name="usuario.usrSenhaConf" />
		
		<label for="TipoUsuario" 		class="col-form-label-sm"><fmt:message key="TipoUsuario"/></label>
		<select id="usuario.tpuId" class="form-control form-control-sm"	name="usuario.tpuId" >
				<c:forEach items="${tpUsuariosLst}" var="tpusuario">
			  	<option value="${tpusuario}" 
			  	    <c:if test="${tpusuario.value == usuario.tpuId.value}">Selected</c:if>>
					${tpusuario}	 
				</option>		
			</c:forEach>
		</select> 
		
		
		
		
	 <label for="status" 		class="col-form-label-sm"><fmt:message key="StaNm"/></label>
		<select id="usuario.statusModel.staId" class="form-control form-control-sm"	name="usuario.statusModel.staId" >
			<option value=0>SELECIONE</option>
			<c:forEach items="${statusLst}" var="status">
				<option value="${status.staId}" 
					<c:if test="${ status.staId == usuario.statusModel.staId}">Selected</c:if> >
					${status.staNm}
				</option>		
			</c:forEach>
		</select> 
			<br>
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/usuario/clear'">Limpar</button>
		 
		<c:if test="${ not empty usuario.usrId }">
			<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/usuario/delete'">Excluir</button>
		</c:if>
		
		<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/usuario/list'">Voltar</button>
	</form>
	
<%@ include file="/resources/jsp/footer.jsp"%>
</body>
</html>

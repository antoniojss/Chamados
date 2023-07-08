<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Usuários</title> 
	<%@ include file="/resources/jsp/header.jsp"%>
</head>

<body class="text-center">

	<form action="/chamados/novoUsuario/salvar" method="post" class="form-default">
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
		
		
		<br>
		<button class="btn btn-primary btn-sm" type="submit">Gravar</button>
	 
	</form>
	
<%@ include file="/resources/jsp/footer.jsp"%>
</body>
</html>

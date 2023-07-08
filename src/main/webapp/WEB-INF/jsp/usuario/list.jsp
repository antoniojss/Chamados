<!DOCTYPE html>
<html>
<head>
	 
	<title>Listagem de Usuários</title> 
	
<%@ include file="/resources/jsp/header.jsp"%></head>

<body class="text-center">

<form action="/chamados/usuario/edit" method="post" class="form-default">
	<%@ include file="/resources/jsp/menu.jsp"%> 

	<h2 class="h3 mb-3 font-weight-normal">Lista de Usuários</h2>
	
	<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/usuario/edit'">Novo Usuário</button>
	<br><br>
	<div style="display:flex; justify-content: center; align-items: center; ">
		<div id="div_displaytagTable">
		
			<display:table name="usuarios" requestURI="/chamados/usuario/list" sort="page" export="true">
				<display:caption media="pdf">Cadastro de Usuários</display:caption>
		
				<display:setProperty name="export.xml" value="false"/>
				<display:setProperty name="export.csv" value="false"/>
				<display:setProperty name="export.pdf" value="true"/>
				
				
				<display:column title="editar" href="read" paramId="usuario.usrId" paramProperty="usrId" media="html">
					editar
				</display:column>
				
				<display:column property="usrNome" titleKey="UsrNome" sortable="true"/>
				<display:column property="usrEmail" titleKey="UsrEmail" sortable="true"/>
				<display:column property="usrTelefone" titleKey="UsrTelefone" sortable="true"/>
				
				<display:column property="usrId" titleKey="UsrId" sortable="true"/>
			</display:table>
		
		</div>
	</div>
</form>
<%@ include file="/resources/jsp/footer.jsp"%>
</body>

</html>

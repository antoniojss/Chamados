<!DOCTYPE html>
<html>
<head>
	 
	<title>Listagem de Chamados</title> 
	
<%@ include file="/resources/jsp/header.jsp"%></head>

<body class="text-center">

<form action="/chamados/chamado/edit" method="post" class="form-default">
	<%@ include file="/resources/jsp/menu.jsp"%> 

	<h2 class="h3 mb-3 font-weight-normal">Lista de Chamados</h2>
	
	<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/chamado/edit'">Novo Chamado</button>
	<br><br>
	<div style="display:flex; justify-content: center; align-items: center; ">
		<div id="div_displaytagTable">
		
			<display:table name="chamadosLst" requestURI="/chamados/chamado/list" sort="page" export="true">
				<display:caption media="pdf">Cadastro de Chamados</display:caption>
		
				<display:setProperty name="export.xml" value="false"/>
				<display:setProperty name="export.csv" value="false"/>
				<display:setProperty name="export.pdf" value="true"/>
				
				
				<display:column title="editar" href="/chamados/chamado/read" paramId="chamado.chaId" paramProperty="chaId" media="html">
					editar
				</display:column>
				
				<display:column property="usuarioModel.usrNome" titleKey="UsrNome" sortable="true"/>
				<display:column property="chmDescricao" titleKey="ChmDescricao" sortable="true"/>
				<display:column property="statusModel.staNm" titleKey="StaNm" sortable="true"/>
				
				<display:column property="chaId" titleKey="ChaId" sortable="true"/>
			</display:table>
		
		</div>
	</div>
</form>
<%@ include file="/resources/jsp/footer.jsp"%>
</body>

</html>

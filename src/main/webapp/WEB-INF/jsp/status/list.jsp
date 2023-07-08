<!DOCTYPE html>
<html>
<head>

	<title>Listagem de Situação</title> 
     <%@ include file="/resources/jsp/header.jsp"%> 

</head>

<body class="text-center">

<form action="/chamados/status/edit" method="post" class="form-default">
	<%@ include file="/resources/jsp/menu.jsp"%> 
	
	<h2 class="h3 mb-3 font-weight-normal">Lista de Status</h2>
	<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/status/edit'">Novo Status</button>
	<br><br>
	<div style="display:flex; justify-content: center; align-items: center; ">
		<div id="div_displaytagTable">
		
			<display:table name="statusLst" requestURI="/chamados/status/list" sort="page" export="true">
				<display:caption media="pdf">Cadastro de Status</display:caption>
		
				<display:setProperty name="export.xml" value="false"/>
				<display:setProperty name="export.csv" value="false"/>
				<display:setProperty name="export.pdf" value="true"/>
				
				
				<display:column title="editar" href="read" paramId="status.staId" paramProperty="staId" media="html">
					editar
				</display:column>
				
				<display:column property="staNm" titleKey="StaNm" sortable="true"/>
				<display:column property="staId" titleKey="StaId" sortable="true"/>
			</display:table>
		
		</div>
	</div>
</form>

<%@ include file="/resources/jsp/footer.jsp"%> 

</body>

</html>

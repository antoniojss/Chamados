<!DOCTYPE html>
<html>
<head>

	<title>Listagem de Setores</title> 
     <%@ include file="/resources/jsp/header.jsp"%> 

</head>

<body class="text-center">

<form action="/chamados/setor/edit" method="post" class="form-default">

	<%@ include file="/resources/jsp/menu.jsp"%> 

	<h2 class="h3 mb-3 font-weight-normal">Lista de Setores</h2>
	
	<button class="btn btn-primary btn-sm" onclick="forms[0].action='/chamados/setor/edit'">Novo Setor</button>
	<br><br>
	<div style="display:flex; justify-content: center; align-items: center; ">
		<div id="div_displaytagTable">
		
			<display:table name="setoresLst" requestURI="/chamados/setor/list" sort="page" export="true">
				<display:caption media="pdf">Cadastro de Setores</display:caption>
		
				<display:setProperty name="export.xml" value="false"/>
				<display:setProperty name="export.csv" value="false"/>
				<display:setProperty name="export.pdf" value="true"/>
				
				
				<display:column title="editar" href="read" paramId="setor.setId" paramProperty="setId" media="html">
					editar
				</display:column>
				
				<display:column property="setNm" titleKey="SetNm" sortable="true"/>
				<display:column property="setId" titleKey="SetId" sortable="true"/>
			</display:table>
		
		</div>
	</div>
</form>
<%@ include file="/resources/jsp/footer.jsp"%></head>
</body>
</html>

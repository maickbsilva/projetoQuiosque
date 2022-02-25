<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
    
	<h1>Lista de Clientes</h1>
	<div class="corpo"><table border="1">
		
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Email</th>
			<th>Gênero</th>
			<th>Telefone/Celular</th>
			<th>Data Nascimento</th>
			<th>Produtos de Interesse</th>
			<th></th>
			<th></th>

			
		</tr>
	
	<c:forEach items="${pessoas }" var="p">
			<tr>
			<td>${p.id}</td>
			<td>${p.nome}</td>
			<td>${p.endereco}</td>
			<td>${p.email}</td>
			<td>${p.genero}</td>
			<td>${p.celular}</td>
			<td><fmt:formatDate value="${p.nascimento.time }" pattern="dd/MMM/yyyy"/></td>
			<td>${p.prodInteresse}</td>
						
			<td><a href="excluirPessoa?idPessoa=${p.id}" onclick="return confirm('Confirmar exclusão do cliente ${p.nome}')"> Excluir</a> </td>
			<td><a href="alterarPessoa?idPessoa=${p.id}" onclick="return confirm('Confirmar alteração do cliente ${p.nome}')"> Alterar</a> </td>

			
			</tr>
	
	</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<p>
	<button><a href="filtroGenero" class="bt"> Filtrar por Gênero</a></button>
	<button><a href="estatisticas" class="bt"> Estatísticas</a></button>
	
	
	</div>

</body>

<style>
body{
    
    font-family: Arial, Helvetica, sans-serif;
}
table{
background-color:#D3D3D3;

}

.corpo{
width:43%;
margin:auto;
padding:1em;
font-weight: bold;
}

h1{
text-align: center;
}

tr{
height: 10px;
}

</style>


 
</html>
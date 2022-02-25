<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estatisticas</title>
</head>
<body>
    
	<h1>Estatísticas</h1>
	
	
		<div class="corpo"><table border="1">
		
		<tr>
			<th>Qtd masculino</th>
			<th>Qtd feminino</th>
			<th>Qtd jovens</th>
			<th>Qtd adultos</th>
			<th>Qtd idosos</th>
		</tr>
	
		<td>${masculino}</td>
		<td>${feminino}</td>
		<td>${jovem}</td>
		<td>${adulto}</td>
		<td>${idoso}</td>
		
</table>
	
		<br>
		<br>
	<table border="1"><tr>
			<th>Domingo</th>
			<th>Segunda</th>
			<th>Terça</th>
			<th>Quarta</th>
			<th>Quinta</th>
			<th>Sexta</th>
			<th>Sábado</th>
		</tr>
		
		
		<td>${domingo}</td>
		<td>${segunda}</td>
		<td>${terca}</td>
		<td>${quarta}</td>
		<td>${quinta}</td>
		<td>${sexta}</td>
		<td>${sabado}</td>
	</table>
	<br>
	<br>
		<table border="1"><tr>
			<th>Cadastros manhã</th>
			<th>Cadastros tarde</th>
			<th>Cadastros noite</th>
		</tr>
		
		
		<td>${manha}</td>
		<td>${tarde}</td>
		<td>${noite}</td>
		
	</table>
	
	</div>

</body>

<style>

body{
    font-family: Arial, Helvetica, sans-serif;
}

table{
	margin-right: auto;
	margin-left: auto;
	background-color:#D3D3D3;
	
}
.corpo{
width:100%;
text-align:center;
margin:auto;
padding:1em;
font-weight: bold;
}

h1{
text-align: center;
}

</style>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
    <div class="principal">
        <h1 class="titulo">
            Cadastro de Cliente ou Visitante
        </h1>

        <form action="salvarObj" method="post">
        
        	<input type="hidden" name="id" value="${pessoa.id }">
        
			<label>Nome:</label>
			<br>
            <input class="form-input" type="text" name="nome" value="${pessoa.nome}" required>
			<br>
			<br>
			<label>Endereço:</label>
			<br>
			<input class="form-input" type="text" name="endereco" value="${pessoa.endereco}" required>
			<br>
			<br>
			<label>E-mail:</label>
			<br>
			<input class="form-input" type="email" name="email" value="${pessoa.email}" required>
			<br>
			<br>
			<label>Gênero:</label>
			<br>
			
			<div name="genero" required>
			<input type="radio" name="genero" value="masculino" ${pessoa.genero == "masculino" ? "checked" : ""} >Masculino
			<input type="radio" name="genero" value="feminino" ${pessoa.genero == "feminino" ? "checked" : ""}>Feminino
			</div>
			
			
			
			<br>
			<label>Telefone/Celular:</label>
			<br>
			<input class="numero" type="tell" name="celular" value="${pessoa.celular}" required>
			<br>
			<br>
			<label>Data de Nascimento:</label>
			<br>
			<input class="dataNascimento" type="date" name="nascimento" value="<fmt:formatDate value="${pessoa.nascimento.time}" pattern="yyyy-MM-dd"/>" required/>
			
			<!-- <fmt:formatDate value="${p.nascimento.time }" pattern="dd-MMM-yyyy"/> -->
			<br>
			<br>
			<label>Produtos de interesse:</label>
			<br>
            <input class="form-input" type="text" name="prodInteresse" value="${pessoa.prodInteresse}" required>
			<br>
			<br>
			
            <input type="submit" value="Enviar">  
        
		    <button><a href="lista_pessoa" class="bt" target="blank">Acessar Lista de Clientes e Visitantes</a></button>
		
		</form>
		
		
        
    </div>
    
      
</body>

<style>

body{
    background-color:white;
    font-family: Arial, Helvetica, sans-serif;
	color:white;

}

.principal{
    width: 33%;
    min-height: 300px;
    margin:auto;
    padding: 1em;
    background-color: #A4A4A4;
}
.titulo {
    border-bottom: 2px solid white;
    font-size: 1.5rem;
    color: white;
  }


.form-input,
.form-button {
  border-radius: 0;
  padding: 0.75em;
  font-size: 0.75em;
}
.form-input {
    outline: none;
    width: 95%;
    border-color: rgba(255, 255, 255, 0.1);
  }
  
.form-button {
    border: 1px;
    background: beige;
    text-transform: uppercase;
    cursor: pointer;
    margin-left: 0.25em;
  }
  
  .bt{
      text-decoration: none;
      color:inherit;
  }


</style>

</html>
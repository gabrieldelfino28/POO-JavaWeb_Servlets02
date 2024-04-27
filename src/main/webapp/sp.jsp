<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Imposto - São Paulo</title>
<link rel="stylesheet" href="./css/styles.css">
</head>
<body>
	<header>
		<a href="index.jsp">Home</a> | <a href="sp.jsp">São Paulo</a> | <a
			href="bh.jsp">Belo Horizonte</a> | <a href="pa.jsp">Porto Alegre</a>
		| <a href=cb.jsp>Curitiba</a>
	</header>
	
	<hr>
	
	<h1>São Paulo</h1>
	
	<div class="form-style" align="center">
		<form action="saoPaulo" method="post">
			<table>
				<tr>
					<td><label>Area do Lote: </label></td> 
				</tr>
				<tr>	
					<td><input type="number"min="125" id="areaTotal" name="areaTotal" required="required"></td>
				</tr>
				<tr>
					<td><label>Número de Quartos: </label></td>
				</tr>
				<tr>	
					<td><input type="number" min="1" id="numQuartos" name="numQuartos" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" id="enviar" name="enviar"></td>
				</tr>
			</table>
			
			<j:if test="${not empty saida}">
				<p class="texto">
					<j:out value="${saida}" />
				</p>
				<p class="texto">
					R$ <j:out value="${impostoTotal}" /> de Imposto a pagar.
				</p>
			</j:if>
		</form>
	</div>
</body>
</html>
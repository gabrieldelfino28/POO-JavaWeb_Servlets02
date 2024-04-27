<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Imposto - Porto Alegre</title>
<link rel="stylesheet" href="./css/styles.css">
</head>
<body>
	<header>
		<a href="index.jsp">Home</a> | <a href="sp.jsp">São Paulo</a> | <a
			href="bh.jsp">Belo Horizonte</a> | <a href="pa.jsp">Porto Alegre</a>
		| <a href=cb.jsp>Curitiba</a>
	</header>
	<hr>
	<h1>Porto Alegre</h1>
	<div class="form-style" align="center">
	<form action="portoAlegre" method="post">
		<table>
				<tr>
					<td><label>Area do Lote: </label></td> 
				</tr>
				<tr>	
					<td><input type="number"min="125" id="areaTotal" name="areaTotal" required="required"></td>
				</tr>
				<tr>
					<td><label>O Lote possuí garagem?</label></td>
				</tr>
				<tr>
					<td>
						<input type="radio" onclick="enableGaragem()" value="Yes" id="radioGaragem" name="radioGaragem" required><label>Sim</label>
						<input type="radio" onclick="disableGaragem()" value="No" id="radioGaragem" name="radioGaragem" required><label>Não</label>
					</td>
				</tr>
				<tr>
					<td><label id=labelGaragem hidden="true">Area da Garagem: </label></td>
				</tr>
				<tr>	
					<td><input hidden="true" type="number" min="20" id="areaGaragem" name="areaGaragem" required></td>
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
	<script src="js/script.js"></script>
</body>
</html>
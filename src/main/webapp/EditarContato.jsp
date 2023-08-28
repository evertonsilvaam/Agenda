<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/phone_icon.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/validador.js"></script>
</head>
<body>

	<h1>Editar contato</h1>
	<form name="frmcontato" action="salvarcontato">
		<table>
			<tr>
				<td><input type="text" id="caixa2" name="idcontato" readonly value="<% out.print(request.getAttribute("idcontato"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="caixa" name="nome"value="<% out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="telefone" name="fone" value="<% out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="caixa" name="email" value="<% out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" class="Botao" value="Salvar" onclick="validar()">
		<input type="button" class="Botao" value="Cancelar" onclick="validar()">
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Novo usuário</title>
<link rel="icon" href="imagens/phone_icon.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/validadorNovoUsuario.js"></script>
</head>
<body>
	<h1>Novo usuário</h1>
	<form name="frmnovousuario" action="novousuario">
		<table>
			<tr>
				<td><input type="text" class="caixa" name="usuario" placeholder="Usuario"></td>
			</tr>
			<tr>
				<td><input type="password" class="caixa" name="senha" placeholder="Senha" ontype="validarSenha()"></td>
			</tr>
			<tr>
				<td>
					<ul>
					  <li class="status_not_ok">letras maiúsculas</li>
					  <li class="status_not_ok">letras minúsculas</li>
					  <li class="status_ok">números</li>
					  <li class="status_not_ok">caracteres especiais</li>
					</ul>
				</td>
			</tr>
			<tr>
				<td><input type="password" class="caixa" name="confirmarsenha" placeholder="ConfirmarSenha"></td>
			</tr>
		</table>
		<input type="button" class="Botao" value="Limpar">
		<input type="button" class="Botao" value="Confirmar" onclick="validar()">

</body>
</html>
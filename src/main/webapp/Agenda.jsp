<%@page import="commons.Variables"%>
<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.DAO" %>
    <% 
//     	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    	DAO dao = new DAO();
    	ArrayList<JavaBeans> lista = dao.obterContatos(Variables.utilizador);
//     	for (int i = 0; i < lista.size(); i++){
//     		out.println(lista.get(i).getIdcontato());
//     		out.println(lista.get(i).getNome());
//     		out.println(lista.get(i).getFone());
//     		out.println(lista.get(i).getEmail());
//     	}
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/phone_icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	
	
	<table >
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody id="tabela">
			<% for (int i = 0; i < lista.size(); i++){ %>
		    	<tr>
		    		<td><% out.println(lista.get(i).getIdcontato());%></td>
		    		<td><% out.println(lista.get(i).getNome());%></td>
		    		<td><% out.println(lista.get(i).getFone());%></td>
		    		<td><% out.println(lista.get(i).getEmail());%></td>
		    		<td><a href= "select" class="Botao">Editar</a></td>
		    	</tr>	
		    	
		    <% }%>
		</tbody>
	</table>
	<a href="NovoContato.html" class="Botao">Novo contato</a>
</body>
</html>
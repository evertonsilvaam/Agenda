package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import commons.Variables;
import model.DAO;
import model.JavaBeans;
import model.Utilizador;

@WebServlet(urlPatterns = {
		"/Controller", 
		"/main", 
		"/novocontato", 
		"/novousuario", 
		"/dologin", 
		"/select", 
		"/salvarcontato", 
		"/excluircontato"
		}
)

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	Utilizador utilizador = new Utilizador();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Action: "+action);
		switch(action) {
		case "/main":
			contatos(request, response);
			break;
		case "/novoContato":
			novoContato(request, response);
			break;
		case "/novousuario":
			novoUsuario(request, response);
			break;
		case "/dologin":
			doLogin(request, response);
			break;
		case "/select":
			listarContato(request, response);
			break;
		case "/salvarcontato":
			salvarContato(request, response);
			break;
		case "/excluircontato":
			excluirContato(request, response);
			break;
		default:
			System.out.println("Page not found");
			response.sendRedirect("Index.html");
			break;
		}
			
	}


	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.obterContatos(utilizador);
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
		}
		
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("NovoContato.html");
		
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.inserirContato(contato);
		
		response.sendRedirect("main");
	}
	
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("novoUsuario.html");
		
		System.out.println(request.getParameter("usuario"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("confirmarsenha"));
	}
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcontato(idcon);
		
		contato = dao.obterDadosContato(contato);
		
		request.setAttribute("idcontato", contato.getIdcontato());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		
//		response.sendRedirect("novoUsuario.html");
		
		RequestDispatcher rd = request.getRequestDispatcher("EditarContato.jsp");
		rd.forward(request, response);
	}
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		utilizador.setUsuario(request.getParameter("usuario"));
		utilizador.setSenha(request.getParameter("senha"));
		
		System.out.println("Usuario dig: :"+utilizador.getUsuario());
		System.out.println("Senha dig: :"+utilizador.getSenha());
		
		Utilizador responseUt = dao.realizaLogin(utilizador);
		
		System.out.println("IdUsuario bd: :"+responseUt.getIdUtilizador());
		System.out.println("Usuario bd: :"+responseUt.getUsuario());
		System.out.println("Senha bd: :"+responseUt.getSenha());
		
		Variables.utilizador = responseUt;
		
		String usuarioBD = utilizador.getUsuario();
		String usuarioDG = responseUt.getUsuario();
		
		if(usuarioBD.equals(usuarioDG)) {
			response.sendRedirect("Agenda.jsp");
		} else {
			response.sendRedirect("Index.html");
			System.out.println("Erro de login");
		}		
	}
	
	protected void salvarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(request.getParameter("idcontato"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		
		contato.setIdcontato(request.getParameter("idcontato"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.salvarContato(contato);
		
		response.sendRedirect("main");
	}
	
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("idcontato"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		
		contato.setIdcontato(request.getParameter("idcontato"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.salvarContato(contato);
		
		response.sendRedirect("main");
	}

}

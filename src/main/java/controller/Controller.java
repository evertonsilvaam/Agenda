package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.x.ContinuousOutputStream;

import model.DAO;
import model.JavaBeans;
import model.Utilizador;

@WebServlet(urlPatterns = {"/Controller", "/main", "/novocontato", "/novousuario", "/dologin"})
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
		default:
			System.out.println("Page not found");
			response.sendRedirect("Index.html");
			break;
		}
			
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("Agenda.jsp");
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
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
		
		System.out.println(request.getParameter("usuario"));
		System.out.println(request.getParameter("senha"));
		utilizador.setUsuario(request.getParameter("usuario"));
	}

}

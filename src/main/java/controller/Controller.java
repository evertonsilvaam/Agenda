package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(urlPatterns = {"/Controller", "/main", "/novocontato", "/novousuario", "/dologin"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
       
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
		response.sendRedirect("Agenda.jsp");
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("NovoContato.html");
		
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
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
	}

}

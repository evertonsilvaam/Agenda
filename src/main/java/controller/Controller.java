package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/"})
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
		case "/insert":
			novoContato(request, response);
			break;
		default:
			System.out.println("Page not found");
			response.sendRedirect("index.html");
			break;
		}
			
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Agenda.jsp");
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("novoContato.jsp");
		
		System.out.println(request.getParameter("nome"));
	}

}

package dm.demos.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

		String action = request.getParameter("action");
		if (action != null && action.equals("LogIN")) {
			String utilisateur = request.getParameter("utilisateur");
			utilisateur = utilisateur.trim();
			if (utilisateur != null && !utilisateur.equals("")) {
				session.setAttribute("utilisateur", utilisateur);
				rd = request.getRequestDispatcher("/ListClimatisationController");
			} else {
				request.setAttribute("utilisateurErreur", "wrong!");
			}
		}

		rd.forward(request, response);
	}

}

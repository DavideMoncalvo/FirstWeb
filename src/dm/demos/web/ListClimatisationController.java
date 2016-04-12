package dm.demos.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.demos.data.ClimatisationDAO;
import fr.demos.formation.Climatisation;

@WebServlet("/ListClimatisationController")
public class ListClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListClimatisationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/listClimatisation.jsp");
		
		List<Climatisation> listClim = null;
		try {ClimatisationDAO dao = new SQLClimatisationDAO();
			listClim = dao.rechercheTout();
		} catch (Exception exc) {
			exc.printStackTrace();
			request.setAttribute("recherceDataErreur", exc.getMessage());
			rd = request.getRequestDispatcher("/listClimatisation.jsp");
		}
		request.setAttribute("listClim", listClim);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

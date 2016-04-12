package dm.demos.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateController")
public class MaDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MaDateController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// d rapresent le model
		Date d = new Date();
		Climatisation clim1 = new Climatisation("salle 203", 25, 1030, 30);

		// transfert du model
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String s = sdf.format(d);
		String h = sdf1.format(d);
		request.setAttribute("dateDuJour", s);
		request.setAttribute("heureDuJour", h);
		request.setAttribute("clim", clim1);

		// appel la view
		RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

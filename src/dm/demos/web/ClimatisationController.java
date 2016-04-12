package dm.demos.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.demos.data.ClimatisationDAO;
import fr.demos.formation.Climatisation;

@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean erreur = false;
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");

		String action = request.getParameter("action");
		if (action != null && action.equals("enregistrer")) {
			String app = request.getParameter("app");
			String temperatureStr = request.getParameter("temperature");
			String pressionStr = request.getParameter("pression");
			String humiditeStr = request.getParameter("humidite");

			request.setAttribute("temperature", temperatureStr);
			request.setAttribute("pression", pressionStr);
			request.setAttribute("humidite", humiditeStr);
			request.setAttribute("app", app);

			double temperature = 0;
			double pression = 0;
			int humidite = 0;

			try {
				temperature = Double.parseDouble(temperatureStr);
			} catch (NumberFormatException exc) {
				erreur = true;
				request.setAttribute("temperatureErreur", "wrong!");
			}
			try {
				pression = Double.parseDouble(pressionStr);
			} catch (NumberFormatException exc) {
				erreur = true;
				request.setAttribute("pressionErreur", "wrong!");
			}
			try {
				humidite = Integer.parseInt(humiditeStr);
			} catch (NumberFormatException exc) {
				erreur = true;
				request.setAttribute("humiditeErreur", "wrong!");

			}

			if (app == null || app.equals("")) {
				erreur = true;
				request.setAttribute("appErreur", "wrong!");
			}

			if (pression <= 0) {
				erreur = true;
				request.setAttribute("pressionErreur", "Pression negative!");
			}
			if (humidite <= 0 || humidite > 100) {
				erreur = true;
				request.setAttribute("humiditeErreur", "Humidite impossible!");
			}

			if (!erreur) {
				Climatisation clim = new Climatisation(app, temperature, pression, humidite);
			
				try{
					ClimatisationDAO dao = new SQLClimatisationDAO();
					dao.sauve(clim);
				rd = request.getRequestDispatcher("/successClimatisation.jsp");
				}catch (Exception exc){
					exc.printStackTrace();
					request.setAttribute("sauvegardeErreur", exc.getMessage());
					rd = request.getRequestDispatcher("/sasieClimatisation.jsp");
				}
				
			
			}
		}

		rd.forward(request, response);
	}}

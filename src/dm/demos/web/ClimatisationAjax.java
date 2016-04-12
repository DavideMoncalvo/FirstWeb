package dm.demos.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.demos.data.ClimatisationDAO;

@WebServlet("/ClimatisationAjax")
public class ClimatisationAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClimatisationAjax() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ClimatisationDAO dao;
		try {
			dao = new SQLClimatisationDAO();
			int nb = dao.nombre("");
			out.println("Il y a "+ nb +" climatisation enregistrees");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

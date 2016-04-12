package dm.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEntetes
 */
@WebServlet("/AfficheEntetes")
public class AfficheEntetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficheEntetes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Enumeration<String> nomsEntete = request.getHeaderNames();
		// objectif afficher le nom de chaque entete et ca valeur

		/*out.println("<html>");

		out.println("<body>");

		while (nomsEntete.hasMoreElements()) {
			String name = (String) nomsEntete.nextElement();
			out.println(name + " : " + request.getHeader(name) + "<br/>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();*/

		// Code pour Faire un tableau
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>"+"Following are the Headers coming from the Client"+"<br/>"+"</h3>");

		out.println("<table border=2 bordercolor=blue>");

		out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

		while (nomsEntete.hasMoreElements()) {
			String name = (String) nomsEntete.nextElement();
			String value = request.getHeader(name);
			// gets each header information separately
			out.println("<tr><th>" + name + "</th><th>" + value + "</th></tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();

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

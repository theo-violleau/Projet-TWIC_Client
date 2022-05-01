package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import api.APIResponse;
import javaBeans.Ville;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Ville> villes;
		HttpSession session = request.getSession();
		villes = APIResponse.getAPIResponse("http://localhost:8181/ville", "GET");
		session.setAttribute("villes", villes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ville1String = request.getParameter("city-select");
		String ville2String = request.getParameter("city-select2");
		Ville ville1 =Ville.fetchCity((ArrayList<Ville>)session.getAttribute("villes"), ville1String);
		Ville ville2 =Ville.fetchCity((ArrayList<Ville>)session.getAttribute("villes"), ville2String);
		double distance = ville1.distance(ville2);
//		On diminue le nombre de digit du double
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		
		String newDistance = f.format(distance);
		session.setAttribute("distance", newDistance);
		session.setAttribute("ville1String", ville1.getNom_commune());
		session.setAttribute("ville2String", ville2.getNom_commune());
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}

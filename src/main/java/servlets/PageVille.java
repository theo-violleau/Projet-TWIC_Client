package servlets;

import java.io.IOException;
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
 * Servlet implementation class PageVille
 */
@WebServlet("/PageVille")
public class PageVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String urlAPI = "http://localhost:8181/ville";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nomVille = request.getParameter("nomVille");
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		Ville villeSelec = Ville.fetchCity(villes, nomVille);
		session.setAttribute("villeSelec", villeSelec);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ville newville = new Ville(request.getParameter("code"), request.getParameter("nom"), request.getParameter("postale"), request.getParameter("libelle"), request.getParameter("ligne5"), request.getParameter("latitude"), request.getParameter("longitude"));
		String urlVille = newville.toURLParameters();
		APIResponse.getAPIResponse(urlAPI+urlVille, "PUT");
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageVille.jsp").forward(request, response);
	}
}

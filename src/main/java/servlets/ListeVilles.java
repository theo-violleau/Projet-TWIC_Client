package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaBeans.Ville;

/**
 * Servlet implementation class ListeVilles
 */
@WebServlet("/ListeVilles")
public class ListeVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeVilles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		int pageInt = Integer.parseInt(page)*49;
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		ArrayList<Ville> villesPage = new ArrayList<Ville>();
		for(int i = pageInt; i<(pageInt+49); i++) {
			if(i<villes.size()) {
				villesPage.add(villes.get(i));
			}
		}
		session.setAttribute("villesPage", villesPage);
		session.setAttribute("page",page);
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String page = request.getParameter("pagenb");
		session.setAttribute("page", page);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeVilles.jsp").forward(request, response);
	}

}

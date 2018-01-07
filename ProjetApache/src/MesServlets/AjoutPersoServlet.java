package MesServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Personne;

/**
 * Servlet implementation class AjoutPersoServlet
 */
@WebServlet(name="AjoutPersoServlet", urlPatterns= {"/ajoutpersonne"})
public class AjoutPersoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPersoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean verifChaine(String s) {
		char c = s.charAt(0);
		if (s.length() < 2 || !(c >= 'A' && c <= 'Z'))
			return false;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z'))
				return false;
		}
		return true;
	}

	/*
	 * public void verifChaine(String s) throws Exception { char c = s.charAt(0); if
	 * (s.length() < 2) throw new
	 * Exception("La chaine doit comporter au moins deux caracrteres");
	 * 
	 * if (!(c >= 'A' && c <= 'Z')) throw new
	 * Exception("La chaine doit comencer par une lettre majuscule");
	 * 
	 * for (int i = 0; i < s.length(); i++) { c = s.charAt(i); if (!(c >= 'a' && c
	 * <= 'z') && !(c >= 'A' && c <= 'Z')) throw new Exception
	 * ("La chaine ne peut contenir que des chaines"); }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(request, response);
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Personne p = new Personne();
	
		
		
		p.setNom(nom);
		p.setPrenom(prenom);
		p.addPersonne();
		
		Boolean verifNom = verifChaine(nom);
		Boolean verifPrenom = verifChaine(prenom);
		request.setAttribute("nomSaisi", nom);
		request.setAttribute("prenomSaisi", prenom);
		if (!verifNom)
			request.setAttribute("nomIncorrect", "format incorrect");
		if (!verifPrenom)
			request.setAttribute("prenomIncorrect", "format incorrect");
		if (!verifNom || !verifPrenom)
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);

	}

}

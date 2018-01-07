package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet implementation class AccueilUser
 */
@WebServlet(name="AccueilUser", urlPatterns= {"/accueiluser"})
public class AccueilUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		boolean test;

		// récupération des saisies de la jsp
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");

		// création des variables de sessions pour le nom et mdp
		HttpSession sessionNom = request.getSession();
		HttpSession sessionMdp = request.getSession();

		// création de l'objet Utilisateur avec les données saisies
		User user = new User(nom, mdp);

		// appel a la méthode pour vérifier la correspondance du nom et mdp
		test = user.verification();
		

		// si la méthode renvoi true: la variable nomOk et mdpOk permet l'accés aux menu,
		//le nom également sera conserver et afficher en permanence
		if (test == true) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
			sessionNom.setAttribute("nomOk", nom);
			sessionMdp.setAttribute("mdpOk", "correct");
		} else {
			sessionMdp.invalidate();
			request.setAttribute("sessionko", "Votre nom et/ ou mdp sont incorrects");
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			
		}
	}
		
}



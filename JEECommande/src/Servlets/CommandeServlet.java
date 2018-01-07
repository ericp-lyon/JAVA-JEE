package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Commande;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet(name = "CommandeServlet", urlPatterns = {"/commandemenu"})
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionMdp = request.getSession();
		if (sessionMdp.getAttribute("mdpOk") == "correct") {

			// récupération du tableau de commande pour l'envoyer dans le select de la JSP
			Commande com = new Commande();
			ArrayList<String> tabCom = new ArrayList<String>();
			tabCom = Commande.RecupCommande();
			request.setAttribute("lesCommandes", tabCom);

			this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}

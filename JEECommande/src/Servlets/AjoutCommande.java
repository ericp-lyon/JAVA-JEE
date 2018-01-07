package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;

/**
 * Servlet implementation class AjoutCommande
 */
@WebServlet(name="AjoutCommande",  urlPatterns= {"/ajoutcommande"})
public class AjoutCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionMdp = request.getSession();
		if (sessionMdp.getAttribute("mdpOk") == "correct") {
			
			// récupération du tableau de client afin de l'envoyer en affichage dans le
						// select de la jsp
						Client client = new Client();
						ArrayList<String> tab = new ArrayList<String>();
						tab = Client.RecupClient();
						request.setAttribute("tabclients", tab);
						System.out.println(tab);
			this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);
			
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

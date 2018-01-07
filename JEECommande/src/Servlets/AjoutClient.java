package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Article;
import beans.Client;

/**
 * Servlet implementation class AjoutClient
 */
@WebServlet(name="AjoutClient", urlPatterns= {"/ajoutclient"})
public class AjoutClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutClient() {
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
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/client.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recupere les infos du formuaire de la vue 
		String nom= request.getParameter("nomClient");
		String prenom= request.getParameter("prenomClient");
	
	
		Client p=new Client();
		
		p.setNom(nom);
		p.setPrenom(prenom);
		p.addClient();
		
		
		//request.setAttribute("designationSaisi", designation);
		//request.setAttribute("prixUSaisi", prixU);
		//request.setAttribute("stockSaisi", stock);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
	}

}

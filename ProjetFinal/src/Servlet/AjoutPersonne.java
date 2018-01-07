package Servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Personne;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet(name="AjoutPersonne", urlPatterns={"/ajoutpersonne"})
public class AjoutPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueAjout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//int num = Integer.parseInt(request.getParameter("num"));
		String nom= request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Personne perso= new Personne();
		System.out.println(nom);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetFinal");
		EntityManager em = emf.createEntityManager();
		
		//perso.setNum(num);
		perso.setNom(nom);
		perso.setPrenom(prenom);
		 
		
		
		EntityTransaction transaction = em.getTransaction();
		 transaction.begin();
		 em.persist(perso);
		 transaction.commit();
		 em.close();
		 emf.close();
		
		
		
		
		
		
	}

}

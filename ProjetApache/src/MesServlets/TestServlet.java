package MesServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.IntegerArraySyncer;

import beans.Personne;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();  // indispensable pour la Servlet
		
		//String nom = request.getParameter("nom");
		//String prenom = request.getParameter("prenom");
		
		/*out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Projet JEE</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello "+ nom + " "+prenom);
		out.println("</body>");
		out.println("</html>");*/
		
		
		// attention bien pensé à l'import bean
		// creation de l'objet type Personne en dur
		/*Personne perso = new Personne();
		perso.setNom("Wick");
		perso.setPrenom("John");
		perso.setSexe('f');
		out.print("Mr " + perso.getNom() + " " +perso.getPrenom()+" sexe : "+ perso.getSexe()) ;
		out.println(perso); // redefinition du toString qui renvoi l'info de l'objet perso
		
		//creation de la requete d'envoi
		
		request.setAttribute("perso",perso);
		
		//envoi de l'objet 'perso' dans le jsp
		/*this.getServletContext().getRequestDispatcher("/WEB-INF/vues.jsp").forward(request,response);*/
		
		
		///exo 2 sur l'envoi d'un calcul
		/*
		String x = (String)request.getParameter("x");
		String y = (String)request.getParameter("y");
		int val1 = Integer.parseInt(x); // permet de récuperer l'entier car par défaut c'est le string qui ressort
		int val2 = Integer.parseInt(y);
		char c = request.getParameter("op").charAt(0);
		System.out.println(" val1 " + c);
		String message = null;

		switch (c) {

		case '+':
			message = "La somme de " + val1 + " et de " + val2 + " vaut: " + (val1 + val2);
			break;

		case '*':
			message = "Le produit de " + val1 + " et de " + val2 + " vaut: " + (val1 * val2);
			break;

		case '/':
			message = "La division de " + val1 + " et de " + val2 + " vaut: " + (float) (val1 / val2);
			break;

		case '-':
			message = "La soustraction de " + val1 + " et de " + val2 + " vaut: " + (val1 - val2);
			break;
		}
			//creation de la requete d'envoi
			
			request.setAttribute("messageEnvoye",message);
		
			//envoi de l'objet 'perso' dans le jsp
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues.jsp").forward(request,response);
		}*/
		
		/*
		String nom= request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int nbre = Integer.parseInt(request.getParameter("nbre"));
		String message="";
		
		for (int i=0; i<nbre+1;i++) {
			
			if(i % 2 ==0) {
				message  = message +i + " "+nom+ "<br>";
				
			}else {
				message  = message +i + " "+prenom+ "<br>";
				
			}
			
			
		}
		
		
		request.setAttribute("messageTransmis",message);*/
		
		//  ajouter personne dans base de donné 'perso'
		/*String nom= request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sexe = request.getParameter("sexe");
		Personne p =new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.addPersonne();*/
		
		// supprimer personne via id
		/*int a = Integer.parseInt(request.getParameter("id"));
		Personne p =new Personne();
		p.effacerPersonne(a);*/
		
		//recup personne par le nom
		/*String nom= request.getParameter("nom");
		Personne pSearch = Personne.recupPersonne(nom);
		String message= pSearch.getNom()+" "+ pSearch.getPrenom();
		request.setAttribute("messageTransmis",message);*/
		/*
		//envoyer une personne avec nom et prenom et faire le changement
		Personne p= new Personne();
		p.setNom("pozo");
		p.setPrenom("eric");
		request.setAttribute("perso",p);
		
		//transmettre une note et voir ensuite l'appreciation
		int note= Integer.parseInt(request.getParameter("note"));
		request.setAttribute("note",note);
		*/
		//prendre 2 chiffres et faire le produit de chaque chiffre et ne garder que les nombres impairs:
		
		/*int nbr1= Integer.parseInt(request.getParameter("nbr1"));
		int nbr2= Integer.parseInt(request.getParameter("nbr2"));
		request.setAttribute("nbr1",nbr1);
		request.setAttribute("nbr2",nbr2);*/
		
		
// faire afficher les indices et alterner affichage nom et prénom en alternance si on met .index ca demarre de 0 si on met .count ca démarre à 1<br>
		
		/*Personne p1= new Personne();
		p1.setNom("Wick");
		p1.setPrenom("john");
		Personne p2= new Personne();
		p2.setNom("dupon");
		p2.setPrenom("joe");
		Personne p3 = new Personne();
		p3.setNom("blanc");
		p3.setPrenom("paul");
		List <Personne> personnes= new ArrayList<Personne>();
		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
		request.setAttribute("personnes",personnes);*/
		
		
		
		//modifier le nom de la pesonne dans la liste en fontion de son indice:
		Personne p1= new Personne();
		p1.setNom("Wick");
		p1.setPrenom("John");
		Personne p2= new Personne();
		p2.setNom("Dupont");
		p2.setPrenom("Joe");
		Personne p3 = new Personne();
		p3.setNom("Blanc");
		p3.setPrenom("Paul");
		List <Personne> personnes= new ArrayList<Personne>();
		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
		request.setAttribute("personnes",personnes);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues.jsp").forward(request, response);
		
		
		
			
		
		
		
	}
	
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

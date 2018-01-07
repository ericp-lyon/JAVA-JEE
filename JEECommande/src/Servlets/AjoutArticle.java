package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import beans.Article;

/**
 * Servlet implementation class AjoutArticle
 */


@WebServlet(name="AjoutArticle", urlPatterns= {"/ajoutarticle"})
public class AjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutArticle() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
			
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
		String designation= request.getParameter("designation");
		int prixU= Integer.parseInt(request.getParameter("prixU"));
		int stock= Integer.parseInt(request.getParameter("stock"));
	
		Article art=new Article();
		
		art.setDesignation(designation);
		art.setPrixU(prixU);
		art.setStock(stock);
		art.addArticle();
		
		//request.setAttribute("designationSaisi", designation);
		//request.setAttribute("prixUSaisi", prixU);
		//request.setAttribute("stockSaisi", stock);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
		
	}

}

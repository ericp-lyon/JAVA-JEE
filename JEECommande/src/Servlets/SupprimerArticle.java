package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Article;

/**
 * Servlet implementation class SupprimerArticle
 */

@WebServlet(name = "SupprimerArticle", urlPatterns = { "/supprimerarticle" })
public class SupprimerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerArticle() {
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

			this.getServletContext().getRequestDispatcher("/WEB-INF/suparticle.jsp").forward(request, response);
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

		String design = request.getParameter("designation");

		Article art = new Article();

		art.setDesignation(design);
		art.deleteArticle(design);

		// request.setAttribute("designationSaisi", designation);
		// request.setAttribute("prixUSaisi", prixU);
		// request.setAttribute("stockSaisi", stock);

		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);

	}

}

package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouterEltPatri
 */
@WebServlet("/ajoutMai")
public class AjouterMaison extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_POST1 ="/WEB-INF/AjouterMaison.jsp";
	public static final String VUE_POST2 ="/WEB-INF/Maisons.jsp"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterMaison() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_POST1).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomElt = request.getParameter( "nom_mai");
		this.getServletContext().getRequestDispatcher(VUE_POST2).forward( request, response );
	}

}

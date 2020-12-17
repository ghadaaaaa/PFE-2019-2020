package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.control.Recherche;
import com.turath.sdb.SDBManipulation;

/**
 * Servlet implementation class StatisticsEltPatri
 */
@WebServlet("/StatisticsEltPatri")
public class StatisticsEltPatri extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/StatisticsEltPatri.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsEltPatri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SDBManipulation sdb = new  SDBManipulation();
		Recherche rech= new Recherche();
		sdb.connexionASDB();
		int nbMaisons= rech.nbMaisons(sdb.getDataset());
		int nbMonuments= rech.nbMonuments(sdb.getDataset());
		int nbSites= rech.nbSites(sdb.getDataset());
		int nbEspaces= rech.nbEspaces(sdb.getDataset());
		//doPost(request, response);
    	HttpSession session = request.getSession();	
    	
    	session.setAttribute("nbMaisons", nbMaisons);
    	session.setAttribute("nbMonuments", nbMonuments);
    	session.setAttribute("nbSites", nbSites);
    	session.setAttribute("nbEspaces", nbEspaces);
    	if (session.getAttribute("adminLog") != null) {	
    		
    		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
    		}
    		else {
    			response.sendRedirect( request.getContextPath() +
    					"/AdminLogin" );
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

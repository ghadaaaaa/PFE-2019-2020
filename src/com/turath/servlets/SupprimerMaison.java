package com.turath.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turath.control.Recherche;
import com.turath.sdb.SDBManipulation;

/**
 * Servlet implementation class SupprimerMaison
 */
@WebServlet("/SupprimerMaison")
public class SupprimerMaison extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE="/WEB-INF/Accueil.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerMaison() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int paramIdMaison =Integer.parseInt(request.getParameter("id_mai"));
		   SDBManipulation sdb = new  SDBManipulation();
		   
		    /************************/
			Recherche rech= new Recherche();
			
			sdb.connexionASDB();
			 
			 /******************/
			List<com.turath.model.Maison> mais = rech.listeMaisons(sdb.getDataset());	
			List<com.turath.model.Site> sites = rech.listeSites(sdb.getDataset());
			List<com.turath.model.Monument> mons = rech.listeMonuments(sdb.getDataset());
			List<com.turath.model.Espace> esps = rech.listeEspaces(sdb.getDataset());
			sdb.deconnexionDeSDB();
		
			request.setAttribute("mais", mais);
			request.setAttribute("sites", sites);
			request.setAttribute("mons", mons);
			request.setAttribute("esps", esps);
		   this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

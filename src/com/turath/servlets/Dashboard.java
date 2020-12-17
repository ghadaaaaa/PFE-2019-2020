package com.turath.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.SDBActorsBean.Architecte;
import com.turath.SDBActorsDAO.SDBAdminConnection;
import com.turath.control.Recherche;
import com.turath.sdb.SDBManipulation;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/Dashboard.jsp";
	

	  
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			List<Architecte> listArchi=new ArrayList<Architecte>();
			SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
			try {
				Connection con= SDBAdminConn.connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(SDBAdminConn.AfficherArchitectesNonValides());
			listArchi=SDBAdminConn.AfficherArchitectesNonValides();
			session.setAttribute("listArchi", listArchi);
			
			//SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
			Architecte architecte= new Architecte();
			//doGet(request,response);
			if (request.getParameter("val") != null) {
			int val = Integer.valueOf(request.getParameter("val"));
			String mail  = request.getParameter("mail");
			System.out.println(val+" "+ mail);
			System.out.println("haya");
			if (val== 1) { // Is the valide button pressed?
		        SDBAdminConn.ValidateArchitecte(architecte,mail);
		        System.out.println("validé");
		        //response.sendRedirect( request.getContextPath() +
					//	"/Dashboard" );
		    }
		    if (val ==0) { // Is the reject button pressed?
		        SDBAdminConn.RefuseArchitecte(architecte,mail);
		        System.out.println("refusé");
		        //response.sendRedirect( request.getContextPath() +
						//"/Dashboard" );
		    }
		    }
			else {
				System.out.println("val null");}
			
			
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
		
		
		
		

	}
	

}

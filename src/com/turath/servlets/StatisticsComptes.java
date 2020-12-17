package com.turath.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.SDBActorsDAO.SDBAdminConnection;
import com.turath.control.Recherche;
import com.turath.sdb.SDBManipulation;

/**
 * Servlet implementation class StatisticsComptes
 */
@WebServlet("/StatisticsComptes")
public class StatisticsComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/StatisticsComptes.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsComptes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SDBAdminConnection sdbAdmin = new SDBAdminConnection();

		int nbArchitectes=0;
		try {
			nbArchitectes = sdbAdmin.nbArchitectes();
			System.out.println("architectes "+ nbArchitectes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nbAdmins=0;
		try {
			nbAdmins = sdbAdmin.nbAdmins();
			System.out.println("admins "+ nbAdmins);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nbExperts=0;
		try {
			nbExperts = sdbAdmin.nbExperts();
			System.out.println("Experts "+ nbExperts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//doPost(request, response);
    	HttpSession session = request.getSession();	
    	
    	session.setAttribute("nbAdmins", nbAdmins);
    	session.setAttribute("nbExperts", nbExperts);
    	session.setAttribute("nbArchitectes", nbArchitectes);
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

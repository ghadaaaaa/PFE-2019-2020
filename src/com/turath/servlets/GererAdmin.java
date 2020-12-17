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

import com.turath.SDBActorsBean.Admin;
import com.turath.SDBActorsBean.Architecte;
import com.turath.SDBActorsDAO.SDBAdminConnection;

/**
 * Servlet implementation class GererAdmin
 */
@WebServlet("/GererAdmin")
public class GererAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/GererAdmin.jsp";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();		
		List<Admin> listAdmin=new ArrayList<Admin>();
		
		if (session.getAttribute("adminLog") != null) {	
		SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		try {
			Connection con= SDBAdminConn.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.setContentType("application/pdf");
		
		String imageName=null;
		
		listAdmin=SDBAdminConn.AfficherAdmins();

		session.setAttribute("listAdmin", listAdmin);
		
		
		//SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		Admin admin= new Admin();
		//doGet(request,response);
		
		
		String mail  = request.getParameter("mail");
			if (mail != null) {
	        SDBAdminConn.SupprimerAdmin(admin,mail);
	        response.sendRedirect( request.getContextPath() +
					"/GererAdmin" );
	        
			}
	  
		
		
		//doPost(request, response);
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

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
import com.turath.SDBActorsBean.Expert;
import com.turath.SDBActorsDAO.SDBAdminConnection;

/**
 * Servlet implementation class DemandesComptesExpert
 */
@WebServlet("/DemandesComptesExpert")
public class DemandesComptesExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/DemandesComptesExpert.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandesComptesExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();		
		List<Expert> listExpert=new ArrayList<Expert>();
		SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		try {
			Connection con= SDBAdminConn.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(SDBAdminConn.AfficherExpertNonValides());
		listExpert=SDBAdminConn.AfficherExpertNonValides();
		session.setAttribute("listExpert", listExpert);
		
		//SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		Expert expert= new Expert();
		//doGet(request,response);
		if (request.getParameter("val") != null) {
		int val = Integer.valueOf(request.getParameter("val"));
		String mail  = request.getParameter("mail");
		System.out.println(val+" "+ mail);
		System.out.println("haya");
		if (val== 1) { // Is the valide button pressed?
	        SDBAdminConn.ValidateExpert(expert,mail);
	        System.out.println("validé");
	        //response.sendRedirect( request.getContextPath() +
				//	"/Dashboard" );
	    }
	    if (val ==0) { // Is the reject button pressed?
	        SDBAdminConn.RefuseExpert(expert,mail);
	        System.out.println("refusé");
	        //response.sendRedirect( request.getContextPath() +
					//"/Dashboard" );
	    }
	    }
		else {
			System.out.println("val null");}
		//doPost(request, response);
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

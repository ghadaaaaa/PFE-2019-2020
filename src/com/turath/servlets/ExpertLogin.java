package com.turath.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.SDBActorsBean.Expert;
import com.turath.SDBActorsDAO.SDBExpertConnection;

/**
 * Servlet implementation class ExpertLogin
 */
@WebServlet("/ExpertLogin")
public class ExpertLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/ExpertLogin.jsp";
	HttpSession session;
	String IdSession;
	String expertLog;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpertLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		IdSession = session.getId();
		if (session.getAttribute("expertLog") == null) {
			this.getServletContext().getRequestDispatcher(VUE).forward( request, response );}
		else {
			response.sendRedirect( request.getContextPath() +
					"/DashboardExpert" );}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				session = request.getSession();
				IdSession = session.getId();
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				Expert acteur= new Expert(email, password);
				SDBExpertConnection SDBExpertConn = new SDBExpertConnection();
				acteur.setMail(email);
				acteur.setPassword(password);
				//SDBManipulation conx= new SDBManipulation();
				//conx.connexionASDB();
				try {
						Connection conx= SDBExpertConn.connect();
					} 
				catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			
				String prenom;
				
				try {
					System.out.println("try");
					if (SDBExpertConn.VerifExistEmailExpert(acteur, email))  {
					 
						session.setAttribute(IdSession, acteur); 
						expertLog = acteur.getPrenom()+" "+acteur.getNom();
						prenom= acteur.getPrenom();
						session.setAttribute("expertLog", expertLog);
						session.setAttribute("prenom",prenom);
						response.sendRedirect( request.getContextPath() +
								"/DashboardExpert" );}
						else  {
							response.sendRedirect( request.getContextPath() +
									"/ExpertLogin" );
						}

					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
	}

}

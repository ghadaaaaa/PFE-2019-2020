package com.turath.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.SDBActorsBean.Architecte;
import com.turath.SDBActorsDAO.SDBArchitectConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/login.jsp";
  
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Architecte acteur= new Architecte(email, password);
		SDBArchitectConnection SDBActConn = new SDBArchitectConnection();
		acteur.setMail(email);
		acteur.setPassword(password);
		//SDBManipulation conx= new SDBManipulation();
		//conx.connexionASDB();
		try {
				Connection conx= SDBActConn.connect();
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		HttpSession session;
		String IdSession;
		String architectLog;
		session = request.getSession();
		IdSession = session.getId();
		String prenom;
		
		try {
			if (SDBActConn.validate(acteur))  {
				System.out.println("ok on verra "+acteur.getPrenom()+" : "+ acteur.isValide());
			 
					if(acteur.isValide()) {
				session.setAttribute("IdSession",IdSession);
				session.setAttribute("acteur", acteur);
				architectLog = acteur.getPrenom()+" "+acteur.getNom();
				prenom= acteur.getPrenom();
				session.setAttribute("architectLog", architectLog);
				session.setAttribute("prenom",prenom);
				response.sendRedirect(request.getContextPath() +
						"/Accueil" );}
				else  {
					System.out.println("nop !valide");
					response.sendRedirect( request.getContextPath() +
							"/Accueil" );
				}
			}
			else {
				System.out.println("nop");
				response.sendRedirect( request.getContextPath() +
						"/Accueil" );
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SDBActConn.verifLogin(email,password);
		System.out.println("after verification login");
		
	}

}

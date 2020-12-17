package com.turath.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.google.common.io.ByteStreams;
import com.turath.SDBActorsBean.Admin;
import com.turath.SDBActorsBean.Architecte;
import com.turath.SDBActorsDAO.SDBArchitectConnection;
import com.turath.SDBActorsDAO.SDBAdminConnection;

/**
 * Servlet implementation class RegistrationAdmin
 */
@WebServlet("/RegistrationAdmin")
@MultipartConfig
public class RegistrationAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/RegistrationAdmin.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		session = request.getSession();
		session.invalidate();
		
		Boolean exist = false;
		
		String IdSession;
		session = request.getSession();
		IdSession = session.getId();
		session.setAttribute("exist", exist);
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String confirm= request.getParameter("ConfirmPassword");
		//byte[] piece_identity=request.getParameter("piece_identity").getBytes();			
		Part filePart = request.getPart("piece_identity"); 
		InputStream fileContent = filePart.getInputStream();
		System.out.println("file content "+ fileContent.toString());
		byte[] piece_identity=  ByteStreams.toByteArray(fileContent);
		System.out.println("piece  "+ piece_identity);
		Admin admin= new Admin(email, password,nom,prenom,piece_identity);
		SDBAdminConnection SDBAdminConn = new SDBAdminConnection();
		int id = 0;
		
		
		try {
			System.out.println("nombre de ID "+ SDBAdminConn.GeneratorId(admin));
			admin.setId(SDBAdminConn.GeneratorId(admin));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		admin.setMail(email);
		admin.setPassword(password);
		admin.setNom(nom);
		admin.setPrenom(prenom);
		admin.setPiece_identity(piece_identity);
			try {
				Connection conx= SDBAdminConn.connect();
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		String prenomNom;
		boolean confirmPwd=true;
		
		try { 
				if (!(SDBAdminConn.VerifExistEmail(admin, email))) {
					System.out.println("verification de l'existance passée");
					if (confirm.equals(password) ) {
						System.out.println("confirm = pws");
				SDBAdminConn.insertAdmin(admin);
				System.out.println("inserted");
				//session.setAttribute(IdSession, archi); 
				//prenomNom = archi.getPrenom()+" "+archi.getNom();
				//session.setAttribute("prenomNom", prenomNom);
				response.sendRedirect( request.getContextPath() +
						"/AdminLogin" );
					}
					else {
						
						System.out.println("pwd erroné!");
						System.out.println("pwd "+ admin.getPassword());
						System.out.println("confirm "+ confirm);
						confirmPwd=false;
						session.setAttribute("confirmPwd", confirmPwd);
							
					}
				}
				else {
					
					System.out.println("email existe déja ! ");
					exist=true;
					session.setAttribute(IdSession, admin); 
					session.setAttribute("exist", exist); 
					
					response.sendRedirect( request.getContextPath() +
							"/RegistrationAdmin" );
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package com.turath.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.common.io.ByteStreams;
import com.turath.SDBActorsBean.Expert;
import com.turath.SDBActorsDAO.SDBExpertConnection;

/**
 * Servlet implementation class RegistrationExpert
 */
@WebServlet("/RegistrationExpert")
public class RegistrationExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/RegistrationExpert.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationExpert() {
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
		String confirm= request.getParameter("ConfirmPassword");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String etablissement=request.getParameter("etablissement").toString();
		
		Part pieceFile = request.getPart("piece_identity"); 
		InputStream pFileContent = pieceFile.getInputStream();
		System.out.println("file content "+ pFileContent.toString());
		byte[] piece_identity=  ByteStreams.toByteArray(pFileContent);
		
		Part diplomeFile = request.getPart("diplome"); 
		InputStream dFileContent = diplomeFile.getInputStream();
		System.out.println("file content "+ dFileContent.toString());
		byte[] diplome=  ByteStreams.toByteArray(dFileContent);
		
		Expert expert= new Expert(email, password,nom,prenom,etablissement,false,piece_identity,diplome);
		SDBExpertConnection SDBActConn = new SDBExpertConnection();
		int id = 0;
		try {
			System.out.println("nombre de ID "+ SDBActConn.GeneratorId(expert));
			expert.setId(SDBActConn.GeneratorId(expert));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		expert.setMail(email);
		expert.setPassword(password);
		expert.setNom(nom);
		expert.setPrenom(prenom);
		expert.setEtablissement(etablissement);
		expert.setPiece_identity(piece_identity);
		expert.setDiplome(diplome);
		//SDBManipulation conx= new SDBManipulation();
		//conx.connexionASDB();
		try {
				Connection conx= SDBActConn.connect();
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		boolean confirmPwd=true;
		
		try { 
				if (!(SDBActConn.VerifExistEmailExpert(expert, email))) {
					System.out.println("verification de l'existance passée");
					if (confirm.equals(password) ) {
						System.out.println("confirm = pws");
						SDBActConn.insertExpert(expert);
						System.out.println("inserted");
						//session.setAttribute(IdSession, archi); 
						//prenomNom = archi.getPrenom()+" "+archi.getNom();
						//session.setAttribute("prenomNom", prenomNom);
						response.sendRedirect( request.getContextPath() +
								"/ExpertLogin" );
					}
					else {
						
						System.out.println("pwd erroné!");
						System.out.println("pwd "+ expert.getPassword());
						System.out.println("confirm "+ confirm);
						confirmPwd=false;
						session.setAttribute("confirmPwd", confirmPwd);
							
					}
				}
				else {
					
					System.out.println("email existe déja ! ");
					exist=true;
					session.setAttribute(IdSession, expert); 
					session.setAttribute("exist", exist); 
					
					response.sendRedirect( request.getContextPath() +
							"/RegistrationExpert" );
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

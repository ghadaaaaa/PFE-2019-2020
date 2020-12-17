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
import com.turath.SDBActorsBean.Architecte;
import com.turath.SDBActorsDAO.SDBArchitectConnection;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/Registration.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String etablissement=request.getParameter("etablissement").toString();
		
		Part pieceFile = request.getPart("piece_identity"); 
		InputStream pFileContent = pieceFile.getInputStream();
		System.out.println("file content "+ pFileContent.toString());
		byte[] piece_identity=  ByteStreams.toByteArray(pFileContent);
		
		Part diplomeFile = request.getPart("diplome"); 
		InputStream dFileContent = diplomeFile.getInputStream();
		System.out.println("file content "+ dFileContent.toString());
		byte[] diplome=  ByteStreams.toByteArray(dFileContent);
		
		Architecte archi= new Architecte(email, password,nom,prenom,etablissement,false,piece_identity,diplome);
		SDBArchitectConnection SDBActConn = new SDBArchitectConnection();
		int id = 0;
		try {
			System.out.println("nombre de ID "+ SDBActConn.GeneratorId(archi));
			archi.setId(SDBActConn.GeneratorId(archi));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		archi.setMail(email);
		archi.setPassword(password);
		archi.setNom(nom);
		archi.setPrenom(prenom);
		archi.setEtablissement(etablissement);
		archi.setPiece_identity(piece_identity);
		archi.setDiplome(diplome);
		//SDBManipulation conx= new SDBManipulation();
		//conx.connexionASDB();
		try {
				Connection conx= SDBActConn.connect();
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		String prenomNom;
		
		
		try { 
				if (!(SDBActConn.VerifExistEmail(archi, email))) {
				SDBActConn.insertArchitecte(archi);
				System.out.println("inserted");
				//session.setAttribute(IdSession, archi); 
				//prenomNom = archi.getPrenom()+" "+archi.getNom();
				//session.setAttribute("prenomNom", prenomNom);
				response.sendRedirect( request.getContextPath() +
						"/RegistrationSuccess" );
				}
				else {
					System.out.println("email existe déja ! ");
					exist=true;
					session.setAttribute(IdSession, archi); 
					session.setAttribute("exist", exist); 
					
					response.sendRedirect( request.getContextPath() +
							"/Registration" );
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

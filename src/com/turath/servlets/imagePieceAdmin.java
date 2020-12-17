package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turath.SDBActorsDAO.SDBAdminConnection;

/**
 * Servlet implementation class imagePiece
 */
@WebServlet("/imagePieceAdmin")
public class imagePieceAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/imagePieceAdmin.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imagePieceAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String imageName = "test.png";
		int id = Integer.parseInt( request.getParameter("num"));
		SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		response.setContentType(getServletContext().getMimeType(imageName));
		response.setContentLength(SDBAdminConn.fileAdmin(id).length);
		System.out.println("length "+SDBAdminConn.fileAdmin(id).length);
        response.getOutputStream().write(SDBAdminConn.fileAdmin(id));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

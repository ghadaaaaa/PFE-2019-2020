package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turath.SDBActorsDAO.SDBArchitectConnection;
import com.turath.SDBActorsDAO.SDBExpertConnection;

/**
 * Servlet implementation class imagePieceExpert
 */
@WebServlet("/imagePieceExpert")
public class imagePieceExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/imagePieceExpert.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imagePieceExpert() {
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
		SDBExpertConnection SDBExpertConn = new SDBExpertConnection ();
		response.setContentType(getServletContext().getMimeType(imageName));
		response.setContentLength(SDBExpertConn.PieceFile(id).length);
		System.out.println("length "+SDBExpertConn.PieceFile(id).length);
        response.getOutputStream().write(SDBExpertConn.PieceFile(id));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turath.SDBActorsDAO.SDBAdminConnection;
import com.turath.SDBActorsDAO.SDBArchitectConnection;

/**
 * Servlet implementation class imagePieceArchitecte
 */
@WebServlet("/imagePieceArchitecte")
public class imagePieceArchitecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/imagePieceArchitecte.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imagePieceArchitecte() {
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
		SDBArchitectConnection SDBArchitecteConn = new SDBArchitectConnection ();
		response.setContentType(getServletContext().getMimeType(imageName));
		response.setContentLength(SDBArchitecteConn.PieceFile(id).length);
		System.out.println("length "+SDBArchitecteConn.PieceFile(id).length);
        response.getOutputStream().write(SDBArchitecteConn.PieceFile(id));
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

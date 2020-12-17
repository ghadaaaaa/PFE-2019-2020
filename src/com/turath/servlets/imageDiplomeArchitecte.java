package com.turath.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turath.SDBActorsDAO.SDBArchitectConnection;

/**
 * Servlet implementation class imageDiplomeArchitecte
 */
@WebServlet("/imageDiplomeArchitecte")
public class imageDiplomeArchitecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/imageDiplomeArchitecte.jsp";    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imageDiplomeArchitecte() {
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
		response.setContentLength(SDBArchitecteConn.DiplomeFile(id).length);
		System.out.println("length "+SDBArchitecteConn.DiplomeFile(id).length);
        response.getOutputStream().write(SDBArchitecteConn.DiplomeFile(id));
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

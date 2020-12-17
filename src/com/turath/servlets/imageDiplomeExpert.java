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
 * Servlet implementation class imageDiplomeExpert
 */
@WebServlet("/imageDiplomeExpert")
public class imageDiplomeExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/imageDiplomeExpert.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imageDiplomeExpert() {
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
		response.setContentLength(SDBExpertConn.DiplomeFile(id).length);
		System.out.println("length "+SDBExpertConn.DiplomeFile(id).length);
        response.getOutputStream().write(SDBExpertConn.DiplomeFile(id));
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

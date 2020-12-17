package com.turath.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turath.control.Recherche;
import com.turath.sdb.SDBManipulation;

/**
 * Servlet implementation class Maisons
 */
@WebServlet("/MaisonsArchitecte")
public class MaisonsArchitecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE ="/WEB-INF/MaisonsArchitecte.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaisonsArchitecte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		SDBManipulation sdb = new  SDBManipulation();
		Recherche rech= new Recherche();
		sdb.connexionASDB();
		List<com.turath.model.Maison> mais = rech.listeMaisons(sdb.getDataset());	
		sdb.deconnexionDeSDB();
		request.setAttribute("mais", mais);
		session.setAttribute("nbMaisons", mais.size());

		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

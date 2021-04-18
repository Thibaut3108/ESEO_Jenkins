package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Ville;
import com.dao.DaoException;
import com.dao.DaoFactory;
import com.dao.VilleDAO;

@WebServlet("/listeVilleController")
public class listeVilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
    public listeVilleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VilleDAO villeDAO = null;

		try {
			villeDAO = DaoFactory.getVilleDaoImpl();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		request.setAttribute("listeVilles", villeDAO.listerVilles());
		request.setAttribute("nombreVille", villeDAO.getNombreVille());
		String param = request.getParameter("start");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("start");
		
		
		
		doGet(request, response);
	}

}

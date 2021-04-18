package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Ville;
import com.dao.DaoException;
import com.dao.DaoFactory;
import com.dao.VilleDAO;

@WebServlet("/auditsController")
public class distanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public distanceController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VilleDAO villeDAO = null;

		try {
			villeDAO = DaoFactory.getVilleDaoImpl();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		request.setAttribute("listeVilles", villeDAO.listerVilles());

		this.getServletContext().getRequestDispatcher("/WEB-INF/distance.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VilleDAO villeDAO = null;

		try {
			villeDAO = DaoFactory.getVilleDaoImpl();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		Ville ville1 = new Ville();
		Ville ville2 = new Ville();

		ville1.setCode_Commune_INSEE(request.getParameter("ville1"));
		ville2.setCode_Commune_INSEE(request.getParameter("ville2"));

		String villeDepart = villeDAO.getNomVilleById(request.getParameter("ville1"));
		String villeArrivee = villeDAO.getNomVilleById(request.getParameter("ville2"));

		request.setAttribute("depart", villeDepart);
		request.setAttribute("arrivee", villeArrivee);

		request.setAttribute("distance", villeDAO.calcul_distance(ville1, ville2));

		this.doGet(request, response);
	}

}

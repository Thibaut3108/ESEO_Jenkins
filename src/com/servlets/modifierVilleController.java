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

@WebServlet("/modifierVilleController")
public class modifierVilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
    public modifierVilleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		VilleDAO villeDAO = null;

		try {
			villeDAO = DaoFactory.getVilleDaoImpl();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("modif");
		System.out.println("id = " + id);
		
		
		session.setAttribute("villeModif", villeDAO.getVilleById(id));

		
		request.setAttribute("listeVilles", villeDAO.listerVilles());
		request.setAttribute("nombreVille", villeDAO.getNombreVille());
		String param = request.getParameter("villeModifier");
		System.out.println("param = " + param);
		session.setAttribute("villeModifier", param);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ville.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String codeCommune = request.getParameter("Code_Commune_INSEE");
		String codepostal = request.getParameter("Code_postal");
		String nomcommune = request.getParameter("Nom_commune");
		String libelle = request.getParameter("libelle");
		String longitude = request.getParameter("Longitude");
		String latitude = request.getParameter("Latitude");

		
		Ville ville= new Ville();
		ville.setCode_Commune_INSEE(codeCommune);
		ville.setCode_postal(codepostal);
		ville.setNom_commune(nomcommune);
		ville.setLibelle_acheminement(libelle);
		//ville.setLongitude(longitude);
		
		VilleDAO villeDAO = null;

		try {
			villeDAO = DaoFactory.getVilleDaoImpl();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		//session.setAttribute("villeModif", ville);
		System.out.println("Nom_commune = " + nomcommune);
		System.out.println("ville = " + ville.getNom_commune());
		villeDAO.modifierVille(ville);
		session.setAttribute("villeModif", ville);
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/listeVilles.jsp").forward(request, response);
		doGet(request, response);
	}

}

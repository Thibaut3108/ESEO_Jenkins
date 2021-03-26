package com.blo;

import java.util.ArrayList;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	private VilleDAO villeDAO;

	public void init(){
		JDBCConfiguration JDBCConf = JDBCConfiguration.getInstance();
		this.villeDAO = JDBCConf.getVilleDao();
	}
	
	//@Autowired
	//private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVille(String param) throws VilleException {
		init();
		ArrayList<Ville> listVille;

		listVille = villeDAO.findAllTrains(param);
		System.out.println("Nombre de ville récupérée(s) : " + listVille.size());

		return listVille;
	}

}


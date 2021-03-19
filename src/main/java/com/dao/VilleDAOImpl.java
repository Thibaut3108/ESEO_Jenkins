package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VilleDAOImpl{
	
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public List<String> getInfoVille() {
		 Statement statement = null;
	     ResultSet resultat = null;
	     Statement statement2 = null;
	     ResultSet resultat2 = null;
	     List<String> res = new ArrayList<String>();
		try {
			statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM ville_france ;");
            while (resultat.next()) {
            	String v = new String(resultat.getString("Nom_Commune"));
            	statement2 = connexion.createStatement();
                res.add(v);
            }	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
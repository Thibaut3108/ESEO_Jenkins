package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	private JDBCConfiguration JDBCConf;
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public VilleDAOImpl(JDBCConfiguration JDBCConf) {
		this.JDBCConf = JDBCConf;
	}

	@Override
	public ArrayList<Ville> findAllTrains(String param) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = JDBCConf.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france ;");
			
			while (resultat.next()) {
				//Ville ville = new Ville(resultat.getString("Nom_Commune"));
				Ville ville = new Ville();
				
				//System.out.println(resultat.getString("Nom_Commune"));
				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVille;
	}

}
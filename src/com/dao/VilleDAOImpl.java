package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.beans.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	@Override
	public List<Ville> listerVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Statement statement = null;
		ResultSet resultat = null;
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france ;");

			while (resultat.next()) {

				String nomCommune = resultat.getString("Nom_commune");
				String Code_postal = resultat.getString("Code_postal");
				String Code_Commune_INSEE = resultat.getString("Code_commune_INSEE");
				String libelle_acheminement = resultat.getString("Libelle_acheminement");

				Ville ville = new Ville(nomCommune, Code_postal, Code_Commune_INSEE, libelle_acheminement);

				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVille;
	}

	@Override
	public Ville getVilleById(String id) {

		Ville ville = new Ville();
		Statement statement = null;
		ResultSet resultat = null;
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france WHERE Code_Commune_INSEE = " + id + ";");

			while (resultat.next()) {

				String nomCommune = resultat.getString("Nom_commune");
				String Code_postal = resultat.getString("Code_postal");
				String libelle_acheminement = resultat.getString("Libelle_acheminement");

				ville = new Ville(nomCommune, Code_postal, id, libelle_acheminement);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ville;
	}

	@Override
	public void modifierVille(Ville ville) {

		System.out.println("num = " + ville.getCode_Commune_INSEE());
		System.out.println("village = " + ville.getNom_commune());
		Statement statement = null;
		int resultat = 0;
		try {
			statement = connexion.createStatement();
			resultat = statement.executeUpdate("UPDATE ville_france SET Nom_commune = '" + ville.getNom_commune()
					+ "' AND libelle = '" + ville.getLibelle_acheminement() + "' AND Code_postal = '"
					+ ville.getCode_postal() + "' WHERE Code_commune_INSEE = " + ville.getCode_Commune_INSEE() + ";");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getNombreVille() {
		Statement statement = null;
		ResultSet resultat = null;
		int nombre = 0;

		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT COUNT(*) FROM ville_france;");

			while (resultat.next()) {
				nombre = resultat.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getNomVilleById(String id) {
		Statement statement = null;
		ResultSet resultat = null;
		String Nom_commune = null;

		try {
			statement = connexion.createStatement();
			resultat = statement
					.executeQuery("SELECT Nom_commune FROM ville_france WHERE Code_Commune_INSEE = " + id + ";");

			while (resultat.next()) {
				Nom_commune = resultat.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Nom_commune;
	}

	@Override
	public float calcul_distance(Ville villeDepart, Ville villeArrivee) {

		Statement statement = null;
		ResultSet resultat = null;
		Statement statement2 = null;
		ResultSet resultat2 = null;
		float distance = 0;
		float delta_x = 0;
		float delta_y = 0;

		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT Latitude, Longitude FROM ville_france WHERE Code_Commune_INSEE = "
					+ villeDepart.getCode_Commune_INSEE() + ";");

			while (resultat.next()) {
				statement2 = connexion.createStatement();
				resultat2 = statement2
						.executeQuery("SELECT Latitude, Longitude FROM ville_france WHERE Code_Commune_INSEE = "
								+ villeArrivee.getCode_Commune_INSEE() + ";");

				while (resultat2.next()) {
					delta_x = (float) Math.pow(Math.abs(resultat.getFloat("Latitude") - resultat2.getFloat("Latitude")),
							2.0);
					delta_y = (float) Math
							.pow(Math.abs(resultat.getFloat("Longitude") - resultat2.getFloat("Longitude")), 2.0);
					distance = (float) Math.sqrt(delta_x + delta_y);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return distance;
	}

}
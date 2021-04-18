package com.beans;

public class Ville {

	private String Nom_commune;
	private String Code_postal;
	private String Code_Commune_INSEE;
	private String libelle_acheminement;
	private float Latitude;
	private float Longitude; 
	// private Coordonnee coordonnee;

	public Ville() {
		super();
	}

	public Ville(String Nom_commune, String Code_postal, String Code_Commune_INSEE, String libelle_acheminement) {
		this.Nom_commune = Nom_commune;
		this.Code_postal = Code_postal;
		this.Code_Commune_INSEE = Code_Commune_INSEE;
		this.libelle_acheminement = libelle_acheminement;
	}
	
	public Ville(float Latitude, float Longitude) {
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}
	public Ville(String Nom_commune) {
		this.Nom_commune = Nom_commune;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public void setLongitude(float longitude) {
		Longitude = longitude;
	}

	public String getNom_commune() {
		return Nom_commune;
	}

	public void setNom_commune(String Nom_commune) {
		this.Nom_commune = Nom_commune;
	}

	public String getCode_postal() {
		return Code_postal;
	}

	public void setCode_postal(String code_postal) {
		Code_postal = code_postal;
	}

	public String getCode_Commune_INSEE() {
		return Code_Commune_INSEE;
	}

	public void setCode_Commune_INSEE(String Code_Commune_INSEE) {
		this.Code_Commune_INSEE = Code_Commune_INSEE;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}
}

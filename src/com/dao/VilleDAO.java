package com.dao;

import java.util.List;
import com.beans.Ville;

public interface VilleDAO {
	
	List<Ville> listerVilles();

	float calcul_distance(Ville villeDepart, Ville villeArrivee);

	String getNomVilleById(String id);

	int getNombreVille();

	Ville getVilleById(String id);

	void modifierVille(Ville ville);
	
}

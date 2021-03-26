package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville implements Serializable{
	private static final long serialVersionUID = -8050478362033217382L;

	private String nomCommune;
	
	//TODO
	//Ajouter attribut code postal 
	/*public Ville() {
		
	}*/
	
/*	public Ville(String nomCommune) {
		this.nomCommune = nomCommune;
	}*/
	
	/*public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}*/
	
}

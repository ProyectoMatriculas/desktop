package model;

import java.util.ArrayList;

public class RequerimentsProfile {
	
	String nom;
	String descripcio;
	ArrayList<String> requisits;
	
	public RequerimentsProfile(String nom, String descripcio, ArrayList<String> requisits) {
		super();
		this.nom = nom;
		this.descripcio = descripcio;
		this.requisits = requisits;
	}

	@Override
	public String toString() {
		return "RequerimentsProfile [nom=" + nom + ", descripcio=" + descripcio + ", requisits=" + requisits + "]";
	}	
	
	

}

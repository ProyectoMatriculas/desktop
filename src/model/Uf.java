package model;

public class Uf {
	
	String CODI_UNITAT_FORMATIVA;
	String NOM_UNITAT_FORMATIVA;
	String DURADA_UNITAT_FORMATIVA;
	
	public Uf(String ufCode, String ufName, String ufDuration) {
		super();
		this.CODI_UNITAT_FORMATIVA = ufCode;
		this.NOM_UNITAT_FORMATIVA = ufName;
		this.DURADA_UNITAT_FORMATIVA = ufDuration;
	}
	
	public String getUfName() {
		
		return NOM_UNITAT_FORMATIVA;
		
	}
	
	public String toString() {
		
		return NOM_UNITAT_FORMATIVA + " (" + DURADA_UNITAT_FORMATIVA + "h)";
		
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	String CODI_CICLE_FORMATIU;			
	String NOM_CICLE_FORMATIU;
	String CODI_ADAPTACIO_CURRICULAR;
	String HORES_CICLE_FORMATIU;
	String DATA_INICI_CICLE_FORMATIU;
	String DATA_FI_CICLE_FORMATIU;
	List<Module> MODULS_CICLE_FORMATIU;
	String INDICADOR_FCT;
	String INDICADOR_SINTESIS;
	String INDICADOR_IDIOMA;
	String INDICADOR_PROJECTE;
	
	
	public Course(String code, String name, String acCode, String hours, String sStartDate, String finishDate) {
		super();
		this.CODI_CICLE_FORMATIU = code;
		this.NOM_CICLE_FORMATIU = name;
		this.CODI_ADAPTACIO_CURRICULAR = acCode;
		this.HORES_CICLE_FORMATIU = hours;
		this.DATA_INICI_CICLE_FORMATIU = sStartDate;
		this.DATA_FI_CICLE_FORMATIU = finishDate;
		this.MODULS_CICLE_FORMATIU = new ArrayList<Module>();
	}
	
	public void addModule(Module m) {
		
		MODULS_CICLE_FORMATIU.add(m);
		
	}

	public String getName() {
		return NOM_CICLE_FORMATIU;
	}
	
	public List<Module> getModules() {
		
		return MODULS_CICLE_FORMATIU;
		
	}

	public void setINDICADOR_FCT(String indFct) {
		INDICADOR_FCT = indFct;
	}

	public void setINDICADOR_SINTESIS(String indSintesis) {
		INDICADOR_SINTESIS = indSintesis;
	}

	public void setINDICADOR_IDIOMA(String indIdioma) {
		INDICADOR_IDIOMA = indIdioma;
	}

	public void setINDICADOR_PROJECTE(String indProjecte) {
		INDICADOR_PROJECTE = indProjecte;
	}

	public String getCODI_CICLE_FORMATIU() {
		return CODI_CICLE_FORMATIU;
	}

	public String getNOM_CICLE_FORMATIU() {
		return NOM_CICLE_FORMATIU;
	}

	public String getCODI_ADAPTACIO_CURRICULAR() {
		return CODI_ADAPTACIO_CURRICULAR;
	}

	public String getHORES_CICLE_FORMATIU() {
		return HORES_CICLE_FORMATIU;
	}

	public String getDATA_INICI_CICLE_FORMATIU() {
		return DATA_INICI_CICLE_FORMATIU;
	}

	public String getDATA_FI_CICLE_FORMATIU() {
		return DATA_FI_CICLE_FORMATIU;
	}

	public List<Module> getMODULS_CICLE_FORMATIU() {
		return MODULS_CICLE_FORMATIU;
	}

	public String getINDICADOR_FCT() {
		return INDICADOR_FCT;
	}

	public String getINDICADOR_SINTESIS() {
		return INDICADOR_SINTESIS;
	}

	public String getINDICADOR_IDIOMA() {
		return INDICADOR_IDIOMA;
	}

	public String getINDICADOR_PROJECTE() {
		return INDICADOR_PROJECTE;
	}	
	
	public String toString() {
		
		return CODI_CICLE_FORMATIU + "    " + NOM_CICLE_FORMATIU;
		
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

public class Module {
	
	String CODI_MODUL;
	String NOM_MODUL;
	String DURADA_MIN_MODUL;
	String DURADA_MAX_MODUL;
	String DATA_INICI_MODUL;
	String DATA_FI_MODUL;
	List<Uf> UFS_MODUL;
	
	public Module(String moduleCode, String moduleName, String moduleMinDuration, String moduleMaxDuration, String moduleStartDate, String moduleFinishDate) {
		super();
		this.CODI_MODUL = moduleCode;
		this.NOM_MODUL = moduleName;
		this.DURADA_MIN_MODUL = moduleMinDuration;
		this.DURADA_MAX_MODUL = moduleMaxDuration;
		this.DATA_INICI_MODUL = moduleStartDate;
		this.DATA_FI_MODUL = moduleFinishDate;
		this.UFS_MODUL = new ArrayList<Uf>();
	}
	
	public void addUf(Uf u) {
		
		UFS_MODUL.add(u);
		
	}
	
	public List<Uf> getModuleUfs() {
		
		return UFS_MODUL;
		
	}
	
	public String getModuleName() {
		
		return NOM_MODUL;
		
	}
	

}

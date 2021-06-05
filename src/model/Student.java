package model;

public class Student {
	
	String convocatoria;
	String codi_solicitud;
	String tipus_solicitud;
	String estat_solicitud;
	String nom;
	String primer_cognom;
	String segon_cognom;
	String identficacio_RALC;
	String tipus_alumne;
	String codi_centre_P1;
	String nom_centre_P1;
	String naturalesa_centre_P1;
	String municipi_centre_P1;
	String SSTT_centre_P1;
	String codi_ensenyament_P1;
	String nom_ensenyament_P1;
	String codi_modalitat;
	String modalitat;
	String curs_P1;
	String regim_P1;
	String torn_P1;
	String DNI;
	String NIE;
	String PASS;
	String TIS;
	String data_naixement;
	String sexe;
	String nacionalitat;
	String pais_naixement;
	String municipi_naixement;
	String tipus_via;
	String nom_via;
	String numero_via;
	String altres_dades;
	String provincia_residencia;
	String municipi_residencia;
	String localitat_residencia;
	String CP;
	String pais_residencia;
	String telefon;
	String correu_electronic;
	String tipus_doc_tutor_1;
	String num_doc_tutor_1;
	String nom_tutor_1;
	String primer_cognom_tutor_1;
	String segon_cognom_tutor_1;
	String tipus_doc_tutor_2;
	String num_doc_tutor_2;
	String nom_tutor_2;
	String primer_cognom_tutor_2;
	String segon_cognom_tutor_2;
	String codi_centre_proc;
	String nom_centre_proc;
	String codi_ensenyament_proc;
	String nom_ensenyament_proc;
	String curs_proc;
	String llengua_enten;
	String religio;
	String centre_assignat;
	
	public Student(String convocatoria, String codi_solicitud, String tipus_solicitud, String estat_solicitud,
			String nom, String primer_cognom, String segon_cognom, String identficacio_RALC,
			String tipus_alumne, String codi_centre_P1, String nom_centre_P1, String naturalesa_centre_P1,
			String municipi_centre_P1, String sSTT_centre_P1, String codi_ensenyament_P1, String nom_ensenyament_P1,
			String codi_modalitat, String modalitat, String curs_P1, String regim_P1, String torn_P1, String dNI,
			String nIE, String pASS, String tIS, String data_naixement, String sexe, String nacionalitat,
			String pais_naixement, String municipi_naixement, String tipus_via, String nom_via, String numero_via,
			String altres_dades, String provincia_residencia, String municipi_residencia, String localitat_residencia,
			String cP, String pais_residencia, String telefon, String correu_electronic, String tipus_doc_tutor_1,
			String num_doc_tutor_1, String nom_tutor_1, String primer_cognom_tutor_1, String segon_cognom_tutor_1,
			String tipus_doc_tutor_2, String num_doc_tutor_2, String nom_tutor_2, String primer_cognom_tutor_2,
			String segon_cognom_tutor_2, String codi_centre_proc, String nom_centre_proc, String codi_ensenyament_proc,
			String nom_ensenyament_proc, String curs_proc, String llengua_enten, String religio,
			String centre_assignat) {
		super();
		this.convocatoria = convocatoria;
		this.codi_solicitud = codi_solicitud;
		this.tipus_solicitud = tipus_solicitud;
		this.estat_solicitud = estat_solicitud;
		this.nom = nom;
		this.primer_cognom = primer_cognom;
		this.segon_cognom = segon_cognom;
		this.identficacio_RALC = identficacio_RALC;
		this.tipus_alumne = tipus_alumne;
		this.codi_centre_P1 = codi_centre_P1;
		this.nom_centre_P1 = nom_centre_P1;
		this.naturalesa_centre_P1 = naturalesa_centre_P1;
		this.municipi_centre_P1 = municipi_centre_P1;
		SSTT_centre_P1 = sSTT_centre_P1;
		this.codi_ensenyament_P1 = codi_ensenyament_P1;
		this.nom_ensenyament_P1 = nom_ensenyament_P1;
		this.codi_modalitat = codi_modalitat;
		this.modalitat = modalitat;
		this.curs_P1 = curs_P1;
		this.regim_P1 = regim_P1;
		this.torn_P1 = torn_P1;
		DNI = dNI;
		NIE = nIE;
		PASS = pASS;
		TIS = tIS;
		this.data_naixement = data_naixement;
		this.sexe = sexe;
		this.nacionalitat = nacionalitat;
		this.pais_naixement = pais_naixement;
		this.municipi_naixement = municipi_naixement;
		this.tipus_via = tipus_via;
		this.nom_via = nom_via;
		this.numero_via = numero_via;
		this.altres_dades = altres_dades;
		this.provincia_residencia = provincia_residencia;
		this.municipi_residencia = municipi_residencia;
		this.localitat_residencia = localitat_residencia;
		CP = cP;
		this.pais_residencia = pais_residencia;
		this.telefon = telefon;
		this.correu_electronic = correu_electronic;
		this.tipus_doc_tutor_1 = tipus_doc_tutor_1;
		this.num_doc_tutor_1 = num_doc_tutor_1;
		this.nom_tutor_1 = nom_tutor_1;
		this.primer_cognom_tutor_1 = primer_cognom_tutor_1;
		this.segon_cognom_tutor_1 = segon_cognom_tutor_1;
		this.tipus_doc_tutor_2 = tipus_doc_tutor_2;
		this.num_doc_tutor_2 = num_doc_tutor_2;
		this.nom_tutor_2 = nom_tutor_2;
		this.primer_cognom_tutor_2 = primer_cognom_tutor_2;
		this.segon_cognom_tutor_2 = segon_cognom_tutor_2;
		this.codi_centre_proc = codi_centre_proc;
		this.nom_centre_proc = nom_centre_proc;
		this.codi_ensenyament_proc = codi_ensenyament_proc;
		this.nom_ensenyament_proc = nom_ensenyament_proc;
		this.curs_proc = curs_proc;
		this.llengua_enten = llengua_enten;
		this.religio = religio;
		this.centre_assignat = centre_assignat;
	}

	public String getNom() {
		return nom;
	}
	
}


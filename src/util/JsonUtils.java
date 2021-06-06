package util;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Course;
import model.Module;
import model.Student;
import model.Uf;

public class JsonUtils {
	
	public static ArrayList<Course> generateCourses() throws IOException, InterruptedException {
		
		ArrayList<Course> coursesList = new ArrayList<Course>();
		
		String responseBody = RequestUtils.getAllRequest("/courses");
			 
		JsonParser jsonParser = new JsonParser();
		
		JsonElement jsonTree = jsonParser.parse(responseBody);
		
		JsonArray courses = jsonTree.getAsJsonArray();
		
		for (JsonElement obj : courses) {
			
			JsonObject course = obj.getAsJsonObject();
			
			String CODI_CICLE_FORMATIU = course.get("CODI_CICLE_FORMATIU").getAsString();
			String NOM_CICLE_FORMATIU = course.get("NOM_CICLE_FORMATIU").getAsString();
			String CODI_ADAPTACIO_CURRICULAR = course.get("CODI_ADAPTACIO_CURRICULAR").getAsString();
			String HORES_CICLE_FORMATIU = course.get("HORES_CICLE_FORMATIU").getAsString();
			String DATA_INICI_CICLE_FORMATIU = course.get("DATA_INICI_CICLE_FORMATIU").getAsString();
			String DATA_FI_CICLE_FORMATIU = course.get("DATA_FI_CICLE_FORMATIU").getAsString();
			
			Course c = new Course(CODI_CICLE_FORMATIU, NOM_CICLE_FORMATIU, CODI_ADAPTACIO_CURRICULAR, HORES_CICLE_FORMATIU, DATA_INICI_CICLE_FORMATIU, DATA_FI_CICLE_FORMATIU);
			
			JsonArray MODULS_CICLE_FORMATIU = course.get("MODULS_CICLE_FORMATIU").getAsJsonArray();
			
			for (JsonElement obj2 : MODULS_CICLE_FORMATIU) {
				
				JsonObject module = obj2.getAsJsonObject();
				
				String CODI_MODUL = module.get("CODI_MODUL").getAsString();
				String NOM_MODUL = module.get("NOM_MODUL").getAsString();
				String DURADA_MIN_MODUL = module.get("DURADA_MIN_MODUL").getAsString();
				String DURADA_MAX_MODUL = module.get("DURADA_MAX_MODUL").getAsString();
				String DATA_INICI_MODUL = module.get("DATA_INICI_MODUL").getAsString();
				String DATA_FI_MODUL = module.get("DATA_FI_MODUL").getAsString();
				
				Module m = new Module(CODI_MODUL, NOM_MODUL, DURADA_MIN_MODUL, DURADA_MAX_MODUL, DATA_INICI_MODUL, DATA_FI_MODUL);
				
				JsonArray UFS_MODUL = module.get("UFS_MODUL").getAsJsonArray();
				
				for (JsonElement obj3 : UFS_MODUL) {
					
					JsonObject uf = obj3.getAsJsonObject();
					
					String CODI_UNITAT_FORMATIVA = uf.get("CODI_UNITAT_FORMATIVA").getAsString();
					String NOM_UNITAT_FORMATIVA = uf.get("NOM_UNITAT_FORMATIVA").getAsString();
					String DURADA_UNITAT_FORMATIVA = uf.get("DURADA_UNITAT_FORMATIVA").getAsString();
					
					Uf u = new Uf(CODI_UNITAT_FORMATIVA, NOM_UNITAT_FORMATIVA, DURADA_UNITAT_FORMATIVA);
					
					m.addUf(u);
					
				}
				
				c.addModule(m);	
				
			}
			
			String INDICADOR_FCT = course.get("INDICADOR_FCT").getAsString();
			String INDICADOR_SINTESIS = course.get("INDICADOR_SINTESIS").getAsString();
			String INDICADOR_IDIOMA = course.get("INDICADOR_IDIOMA").getAsString();
			String INDICADOR_PROJECTE = course.get("INDICADOR_PROJECTE").getAsString();
			
			c.setINDICADOR_FCT(INDICADOR_FCT);
			c.setINDICADOR_SINTESIS(INDICADOR_SINTESIS);
			c.setINDICADOR_IDIOMA(INDICADOR_IDIOMA);
			c.setINDICADOR_PROJECTE(INDICADOR_PROJECTE);
			
			coursesList.add(c);
			
		}
		
		return coursesList;
		
	}
	
	public static ArrayList<Student> generateStudents(String jsonString) throws IOException, InterruptedException {
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		JsonParser jsonParser = new JsonParser();
		
		JsonElement jsonTree = jsonParser.parse(jsonString);
		
		JsonArray students = jsonTree.getAsJsonArray();
		
		for (JsonElement obj : students) {
			
			JsonObject student = obj.getAsJsonObject();
			
			String convocatoria = student.get("convocatoria").getAsString();
			String codi_solicitud = student.get("codi_solicitud").getAsString();
			String tipus_solicitud = student.get("tipus_solicitud").getAsString();
			String estat_solicitud = student.get("estat_solicitud").getAsString();
			String nom = student.get("nom").getAsString();
			String primer_cognom = student.get("primer_cognom").getAsString();
			String segon_cognom = student.get("segon_cognom").getAsString();
			String identficacio_RALC = student.get("identficacio_RALC").getAsString();
			String tipus_alumne = student.get("tipus_alumne").getAsString();
			String codi_centre_P1 = student.get("codi_centre_P1").getAsString();
			String nom_centre_P1 = student.get("nom_centre_P1").getAsString();
			String naturalesa_centre_P1 = student.get("naturalesa_centre_P1").getAsString();
			String municipi_centre_P1 = student.get("municipi_centre_P1").getAsString();
			String SSTT_centre_P1 = student.get("SSTT_centre_P1").getAsString();
			String codi_ensenyament_P1 = student.get("codi_ensenyament_P1").getAsString();
			String nom_ensenyament_P1 = student.get("nom_ensenyament_P1").getAsString();
			String codi_modalitat = student.get("codi_modalitat").getAsString();
			String modalitat = student.get("modalitat").getAsString();
			String curs_P1 = student.get("curs_P1").getAsString();
			String regim_P1 = student.get("regim_P1").getAsString();
			String torn_P1 = student.get("torn_P1").getAsString();
			String DNI = student.get("DNI").getAsString();
			String NIE = student.get("NIE").getAsString();
			String PASS = student.get("PASS").getAsString();
			String TIS = student.get("TIS").getAsString();
			String data_naixement = student.get("data_naixement").getAsString();
			String sexe = student.get("sexe").getAsString();
			String nacionalitat = student.get("nacionalitat").getAsString();
			String pais_naixement = student.get("pais_naixement").getAsString();
			String municipi_naixement = student.get("municipi_naixement").getAsString();
			String tipus_via = student.get("tipus_via").getAsString();
			String nom_via = student.get("nom_via").getAsString();
			String numero_via = student.get("numero_via").getAsString();
			String altres_dades = student.get("altres_dades").getAsString();
			String provincia_residencia = student.get("provincia_residencia").getAsString();
			String municipi_residencia = student.get("municipi_residencia").getAsString();
			String localitat_residencia = student.get("localitat_residencia").getAsString();
			String CP = student.get("CP").getAsString();
			String pais_residencia = student.get("pais_residencia").getAsString();
			String telefon = student.get("telefon").getAsString();
			String correu_electronic = student.get("correu_electronic").getAsString();
			String tipus_doc_tutor_1 = student.get("tipus_doc_tutor_1").getAsString();
			String num_doc_tutor_1 = student.get("num_doc_tutor_1").getAsString();
			String nom_tutor_1 = student.get("nom_tutor_1").getAsString();
			String primer_cognom_tutor_1 = student.get("primer_cognom_tutor_1").getAsString();
			String segon_cognom_tutor_1 = student.get("segon_cognom_tutor_1").getAsString();
			String tipus_doc_tutor_2 = student.get("tipus_doc_tutor_2").getAsString();
			String num_doc_tutor_2 = student.get("num_doc_tutor_2").getAsString();
			String nom_tutor_2 = student.get("nom_tutor_2").getAsString();
			String primer_cognom_tutor_2 = student.get("primer_cognom_tutor_2").getAsString();
			String segon_cognom_tutor_2 = student.get("segon_cognom_tutor_2").getAsString();
			String codi_centre_proc = student.get("codi_centre_proc").getAsString();
			String nom_centre_proc = student.get("nom_centre_proc").getAsString();
			String codi_ensenyament_proc = student.get("codi_ensenyament_proc").getAsString();
			String nom_ensenyament_proc = student.get("nom_ensenyament_proc").getAsString();
			String curs_proc = student.get("curs_proc").getAsString();
			String llengua_enten = student.get("llengua_enten").getAsString();
			String religio = student.get("religio").getAsString();
			String centre_assignat = student.get("centre_assignat").getAsString();
			
			Student s = new Student(convocatoria, codi_solicitud, tipus_solicitud, estat_solicitud, nom, primer_cognom, segon_cognom, identficacio_RALC, tipus_alumne, codi_centre_P1, nom_centre_P1, naturalesa_centre_P1, municipi_centre_P1, SSTT_centre_P1, codi_ensenyament_P1, nom_ensenyament_P1, codi_modalitat, modalitat, curs_P1, regim_P1, torn_P1, DNI, NIE, PASS, TIS, data_naixement, sexe, nacionalitat, pais_naixement, municipi_naixement, tipus_via, nom_via, numero_via, altres_dades, provincia_residencia, municipi_residencia, localitat_residencia, CP, pais_residencia, telefon, correu_electronic, tipus_doc_tutor_1, num_doc_tutor_1, nom_tutor_1, primer_cognom_tutor_1, segon_cognom_tutor_1, tipus_doc_tutor_2, num_doc_tutor_2, nom_tutor_2, primer_cognom_tutor_2, segon_cognom_tutor_2, codi_centre_proc, nom_centre_proc, codi_ensenyament_proc, nom_ensenyament_proc, curs_proc, llengua_enten, religio, centre_assignat);
			
			studentsList.add(s);
			
		}
		
		return studentsList;
		
	}

}

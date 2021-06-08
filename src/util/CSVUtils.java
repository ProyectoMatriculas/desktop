package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Course;
import model.Module;
import model.Student;
import model.Uf;

public class CSVUtils {
	
	public static ArrayList<Course> CourseCSVReader(String fileDir) throws IOException, InterruptedException {
		 		 
		ArrayList<Course> coursesList = new ArrayList<Course>();
		 
		Course c = null;
		
		Module m = null;
		 
		String lastCourse = "";
		String lastModule = "";		
		
		BufferedReader csvReader = new BufferedReader(new FileReader(fileDir));
		 
		String row = null;
		
		row = csvReader.readLine();
		 
		while((row = csvReader.readLine()) != null) {
			
			String[] data = row.split(";");
			 
			// Course
			 
			String courseCode = data[0];	
			
			String courseName = data[1];
			
			String acCode = data[2];
			
			String courseHours = data[3];
			
			String courseStartDate = data[4];
			
			String courseFinishDate = data[5];
			
			if (!lastCourse.equals(courseCode)) {
				
				if (m != null) {
					
					c.addModule(m);
					
					coursesList.add(c);
					
				}
	
				c = new Course(courseCode, courseName, acCode, courseHours, courseStartDate, courseFinishDate);
				
				lastCourse = courseCode;
				
			}
			
			// Module
			
			String moduleCode = data[6];
			String moduleName = data[7];
			String moduleMinDuration = data[8];
			String moduleMaxDuration = data[9];
			String moduleStartDate = data[10];
			String moduleFinishDate = data[11];
			
			if (!lastModule.equals(moduleCode)) {
				
				if (m != null) {
					
					c.addModule(m);
					
				}
				
				m = new Module(moduleCode, moduleName, moduleMinDuration, moduleMaxDuration, moduleStartDate, moduleFinishDate);
				
				lastModule = moduleCode;
				
			}
			
			// UF
			
			String ufCode = data[12];
			String ufName = data[13];
			String ufDuration = data[14];
			
			Uf u = new Uf(ufCode, ufName, ufDuration);
			
			m.addUf(u);
			
			// Indicators
			
			String indicatorFCT = data[15];
			String indicatorSintesis = data[16];
			String indicatorIdioma = data[17];
			String indicatorProjecte = data[18];
			
			c.setINDICADOR_FCT(indicatorFCT);
			c.setINDICADOR_SINTESIS(indicatorSintesis);
			c.setINDICADOR_IDIOMA(indicatorIdioma);
			c.setINDICADOR_PROJECTE(indicatorProjecte);
			
		}
		
		csvReader.close();
		
		return coursesList;
		 
	}
	
	public static ArrayList<Student> StudentsCSVReader(String fileDir) throws IOException, InterruptedException {
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		 
		Student s = null;
		
		BufferedReader csvReader = new BufferedReader(new FileReader(fileDir));
		 
		String row = null;
		
		row = csvReader.readLine();
		 
		while((row = csvReader.readLine()) != null) {
						
			String[] data = row.split(",");
			 
			// Student
			 
			String convocatoria = data[0];
			String codi_solicitud = data[1];
			String tipus_solicitud = data[2];
			String estat_solicitud = data[3];
			String nom = data[4];
			String primer_cognom = data[5];
			String segon_cognom = data[6];
			String identficacio_RALC = data[7];
			String tipus_alumne = data[8];
			String codi_centre_P1 = data[9];
			String nom_centre_P1 = data[10];
			String naturalesa_centre_P1 = data[11];
			String municipi_centre_P1 = data[12];
			String SSTT_centre_P1 = data[13];
			String codi_ensenyament_P1 = data[14];
			String nom_ensenyament_P1 = data[15];
			String codi_modalitat = data[16];
			String modalitat = data[17];
			String curs_P1 = data[18];
			String regim_P1 = data[19];
			String torn_P1 = data[20];
			String DNI = data[21];
			String NIE = data[22];
			String PASS = data[23];
			String TIS = data[24];
			String data_naixement = data[25];
			String sexe = data[26];
			String nacionalitat = data[27];
			String pais_naixement = data[28];
			String municipi_naixement = data[29];
			String tipus_via = data[30];
			String nom_via = data[31];
			String numero_via = data[32];
			String altres_dades = data[33];
			String provincia_residencia = data[34];
			String municipi_residencia = data[35];
			String localitat_residencia = data[36];
			String CP = data[37];
			String pais_residencia = data[38];
			String telefon = data[39];
			String correu_electronic = data[40];
			String tipus_doc_tutor_1 = data[41];
			String num_doc_tutor_1 = data[42];
			String nom_tutor_1 = data[43];
			String primer_cognom_tutor_1 = data[44];
			String segon_cognom_tutor_1 = data[45];
			String tipus_doc_tutor_2 = data[46];
			String num_doc_tutor_2 = data[47];
			String nom_tutor_2 = data[48];
			String primer_cognom_tutor_2 = data[49];
			String segon_cognom_tutor_2 = data[50];
			String codi_centre_proc = data[51];
			String nom_centre_proc = data[52];
			String codi_ensenyament_proc = data[53];
			String nom_ensenyament_proc = data[54];
			String curs_proc = data[55];
			String llengua_enten = data[56];
			String religio = data[57];
			String centre_assignat = data[58];
			
			s = new Student(convocatoria, codi_solicitud, tipus_solicitud, estat_solicitud, nom, primer_cognom, segon_cognom, identficacio_RALC, tipus_alumne, codi_centre_P1, nom_centre_P1, naturalesa_centre_P1, municipi_centre_P1, SSTT_centre_P1, codi_ensenyament_P1, nom_ensenyament_P1, codi_modalitat, modalitat, curs_P1, regim_P1, torn_P1, DNI, NIE, PASS, TIS, data_naixement, sexe, nacionalitat, pais_naixement, municipi_naixement, tipus_via, nom_via, numero_via, altres_dades, provincia_residencia, municipi_residencia, localitat_residencia, CP, pais_residencia, telefon, correu_electronic, tipus_doc_tutor_1, num_doc_tutor_1, nom_tutor_1, primer_cognom_tutor_1, segon_cognom_tutor_1, tipus_doc_tutor_2, num_doc_tutor_2, nom_tutor_2, primer_cognom_tutor_2, segon_cognom_tutor_2, codi_centre_proc, nom_centre_proc, codi_ensenyament_proc, nom_ensenyament_proc, curs_proc, llengua_enten, religio, centre_assignat);
			
			studentsList.add(s);
			
		}
		
		csvReader.close();
		
		String jsonString = new Gson().toJson(studentsList);
		
		System.out.println(jsonString);
		
		RequestUtils.httpPostRequest("/students/create", jsonString);
		
		return studentsList;
		
	}

}

package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Course;
import model.Module;
import model.Uf;

public class CSVUtils {
	
	public static void CourseCSVReader(String fileDir) throws IOException, InterruptedException {
		 		 
		List<Course> coursesList = new ArrayList<Course>();
		 
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
		
//		for (int i = 0; i < coursesList.size(); i++) {
//			
//			System.out.println("Course " + (i+1) + " >>> " + coursesList.get(i).getName());
//			
//			List<Module> courseModules = coursesList.get(i).getModules();
//			
//			for (int j = 0; j < courseModules.size(); j++) {
//				
//				System.out.println("Module " + (i+1) + "." + (j+1) + " >>> " + courseModules.get(j).getModuleName());
//				
//				List<Uf> moduleUfs = courseModules.get(j).getModuleUfs();
//				
//				for (int k = 0; k < moduleUfs.size(); k++) {
//					
//					System.out.println("Uf " + (i+1) + "." + (j+1) + "." + (k+1) + " >>> " + moduleUfs.get(k).getUfName());
//					
//				}
//				
//			}
//			
//		}
		
		ArrayList<Course> testList = new ArrayList<Course>();
		
		testList.add(coursesList.get(3));
		testList.add(coursesList.get(12));
		testList.add(coursesList.get(42));
		
		String json = new Gson().toJson(testList);
		
		RequestUtils.httpPostRequest("/courses/create", json);
		 
	}
	
	public static void StudentsCSVReader(String fileDir) throws IOException, InterruptedException {
		
		
		
	}

}

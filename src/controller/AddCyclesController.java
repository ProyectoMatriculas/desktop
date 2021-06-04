package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import model.Course;
import util.CSVUtils;

public class AddCyclesController {
	
	private ArrayList<Course> coursesList;
	
	@FXML
	private Button btnImportCourses;
	
	@FXML
	private Button btnImportStudents;

	@FXML
	private void importCourses(ActionEvent event) throws IOException, InterruptedException {
		
		String fileDir = selectCSVFile();
		
		coursesList = CSVUtils.CourseCSVReader(fileDir);
		
	}
	
	@FXML
	private void importStudents(ActionEvent event) throws IOException, InterruptedException {
		
		String fileDir = selectCSVFile();
		
		CSVUtils.StudentsCSVReader(fileDir);
		
	}

	private String selectCSVFile() {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar fichero");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);
		
		System.out.println(file.getName());
		
		return file.getAbsolutePath();
		
	}
	
}



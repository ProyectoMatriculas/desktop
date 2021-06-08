package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

import model.Course;
import util.CSVUtils;
import util.RequestUtils;

public class AddCoursesController {
	
	private ArrayList<Course> coursesList;
	
	@FXML
	private TableView<Course> tableid;
	
	@FXML
	private TableColumn<Course, String> courseCode;
	
	@FXML
	private TableColumn<Course, String> courseName;
	
	@FXML
	private TableColumn<Course, String> acCode;
	
	@FXML
	private TableColumn<Course, String> courseHours;
	
	@FXML
	private TableColumn<Course, String> courseStartDate;
	
	@FXML
	private TableColumn<Course, String> courseFinishDate;
	
	@FXML
	private Button btnImportCourses;
	
	@FXML
	private Button btnBackMenu;
	
	@FXML
	private Button btnSend;

	@FXML
	private void importCourses(ActionEvent event) throws IOException, InterruptedException {
		
		String fileDir = selectCSVFile();
		
		coursesList = CSVUtils.CourseCSVReader(fileDir); 
		
		tableid.getSelectionModel().setSelectionMode(
			    SelectionMode.MULTIPLE
			);
		
		courseCode.setCellValueFactory(new PropertyValueFactory<>("CODI_CICLE_FORMATIU"));
		courseName.setCellValueFactory(new PropertyValueFactory<>("NOM_CICLE_FORMATIU"));
		acCode.setCellValueFactory(new PropertyValueFactory<>("CODI_ADAPTACIO_CURRICULAR"));
		courseHours.setCellValueFactory(new PropertyValueFactory<>("HORES_CICLE_FORMATIU"));
		courseStartDate.setCellValueFactory(new PropertyValueFactory<>("DATA_INICI_CICLE_FORMATIU"));
		courseFinishDate.setCellValueFactory(new PropertyValueFactory<>("DATA_FI_CICLE_FORMATIU"));
		
		for (Course i : coursesList) {
			
			tableid.getItems().add(i);
			
		}
		
		
	}
	
	@FXML
	private void addCourses(ActionEvent event) throws IOException, InterruptedException{
		List<Course> courses = tableid.getSelectionModel().getSelectedItems();
		
		ArrayList<Course> coursesToAdd = new ArrayList<Course>();
		
		for (Course course : courses) {
			
			coursesToAdd.add(course);
			
		}
		
		String jsonString = new Gson().toJson(coursesToAdd);
		
		String responseBody = RequestUtils.httpPostRequest("/courses/create", jsonString);
		
		if (responseBody.equals("Error")) {
			
			Alert alert = new Alert (AlertType.INFORMATION, "No se han insertado cursos, ya estaban agregados");
			
			alert.show();
			
		} else {
			
			Alert alert = new Alert (AlertType.INFORMATION, "Cursos insertados correctamente");
			
			alert.show();
			
		}
		
		
		
	}
	
	@FXML
	private void importStudents(ActionEvent event) throws IOException, InterruptedException {
		
		String fileDir = selectCSVFile();
		
		CSVUtils.StudentsCSVReader(fileDir);
		
	}
	
	@FXML
	private void backMenu(ActionEvent event) throws IOException, InterruptedException {
		changeScene("MenuView.fxml");
	}

	private String selectCSVFile() {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar fichero");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);
		
		return file.getAbsolutePath();
		
	}
	
	@FXML
    void exit(ActionEvent event) {
    	
    	System.exit(0);

    }	
	
	void changeScene(String nextScene) throws IOException {
	    	
	    	Stage stage = new Stage();
			
			Parent root = FXMLLoader.load(LoginController.class.getResource("../view/" + nextScene));
			
			Scene scene = new Scene(root);
			
			stage.initStyle(StageStyle.DECORATED.UNDECORATED);
		
			stage.setScene(scene);
			stage.show();
			
			btnImportCourses.getScene().getWindow().hide();
	    	
	    }
	
}



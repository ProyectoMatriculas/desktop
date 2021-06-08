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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Course;
import model.Student;
import util.CSVUtils;
import util.RequestUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddStudentsController {
	
	@FXML
	private Button btnBack;
	
	@FXML
	private Button btnSend;
	
	@FXML
	private Button btnImportAlumns;
	
	private ArrayList<Student> studentsList;
	
	@FXML
	private TableView<Student> tableid;
	
	@FXML
	private TableColumn<Student, String> convocatoria;
	
	@FXML
	private TableColumn<Student, String> codi_solicitud;
	
	@FXML
	private TableColumn<Student, String> tipus_solicitud;
	
	@FXML
	private TableColumn<Student, String> estat_solicitud;
	
	@FXML
	private TableColumn<Student, String> nom;
	
	@FXML
	private TableColumn<Student, String> primer_cognom;
	
	@FXML
	private TableColumn<Student, String> segon_cognom;
	
	@FXML
	private TableColumn<Student, String> identficacio_RALC;
	
	@FXML
	private TableColumn<Student, String> tipus_alumne;
	
	@FXML
	private TableColumn<Student, String> codi_centre_P1;
	
	@FXML
	private TableColumn<Student, String> nom_centre_P1;
	
	@FXML
	private TableColumn<Student, String> naturalesa_centre_P1;
	
	@FXML
	private TableColumn<Student, String> municipi_centre_P1;
	
	@FXML
	private TableColumn<Student, String> SSTT_centre_P1;
	
	@FXML
	private TableColumn<Student, String> codi_ensenyament_P1;
	
	@FXML
	private TableColumn<Student, String> nom_ensenyament_P1;
	
	@FXML
	private TableColumn<Student, String> codi_modalitat;
	
	@FXML
	private TableColumn<Student, String> modalitat;
	
	@FXML
	private TableColumn<Student, String> curs_P1;
	
	@FXML
	private TableColumn<Student, String> regim_P1;
	
	@FXML
	private TableColumn<Student, String> torn_P1;
	
	@FXML
	private TableColumn<Student, String> DNI;
	
	@FXML
	private TableColumn<Student, String> NIE;
	
	@FXML
	private TableColumn<Student, String> PASS;
	
	@FXML
	private TableColumn<Student, String> TIS;
	
	@FXML
	private TableColumn<Student, String> data_naixement;

	@FXML
	private TableColumn<Student, String> sexe;
	
	@FXML
	private TableColumn<Student, String> nacionalitat;
	
	@FXML
	private TableColumn<Student, String> pais_naixement;
	
	@FXML
	private TableColumn<Student, String> municipi_naixement;
	
	@FXML
	private TableColumn<Student, String> tipus_via;
	
	@FXML
	private TableColumn<Student, String> nom_via;
	
	@FXML
	private TableColumn<Student, String> numero_via;
	
	@FXML
	private TableColumn<Student, String> altres_dades;
	
	@FXML
	private TableColumn<Student, String> provincia_residencia;
	
	@FXML
	private TableColumn<Student, String> municipi_residencia;
	
	@FXML
	private TableColumn<Student, String> localitat_residencia;
	
	@FXML
	private TableColumn<Student, String> CP;
	
	@FXML
	private TableColumn<Student, String> pais_residencia;
	
	@FXML
	private TableColumn<Student, String> telefon;
	
	@FXML
	private TableColumn<Student, String> correu_electronic;
	
	@FXML
	private TableColumn<Student, String> tipus_doc_tutor_1;
	
	@FXML
	private TableColumn<Student, String> num_doc_tutor_1;
	
	@FXML
	private TableColumn<Student, String> nom_tutor_1;
	
	@FXML
	private TableColumn<Student, String> primer_cognom_tutor_1;
	
	@FXML
	private TableColumn<Student, String> segon_cognom_tutor_1;
	
	@FXML
	private TableColumn<Student, String> tipus_doc_tutor_2;
	
	@FXML
	private TableColumn<Student, String> num_doc_tutor_2;
	
	@FXML
	private TableColumn<Student, String> nom_tutor_2;
	
	@FXML
	private TableColumn<Student, String> primer_cognom_tutor_2;
	
	@FXML
	private TableColumn<Student, String> segon_cognom_tutor_2;
	
	@FXML
	private TableColumn<Student, String> codi_centre_proc;
	
	@FXML
	private TableColumn<Student, String> nom_centre_proc;
	
	@FXML
	private TableColumn<Student, String> codi_ensenyament_proc;
	
	@FXML
	private TableColumn<Student, String> nom_ensenyament_proc;
	
	@FXML
	private TableColumn<Student, String> curs_proc;
	
	@FXML
	private TableColumn<Student, String> llengua_enten;
	
	@FXML
	private TableColumn<Student, String> religio;
	
	@FXML
	private TableColumn<Student, String> centre_assignat;
	
	
	@FXML
	private void backMenu(ActionEvent event) throws IOException, InterruptedException {
		changeScene("MenuView.fxml");
	}
	
	@FXML
	private void importAlumns(ActionEvent event) throws IOException, InterruptedException {
		
		String fileDir = selectCSVFile();
		
		studentsList = CSVUtils.StudentsCSVReader(fileDir); 
		
		tableid.getSelectionModel().setSelectionMode(
			    SelectionMode.MULTIPLE
			);
		
		convocatoria.setCellValueFactory(new PropertyValueFactory<>("convocatoria"));
		codi_solicitud.setCellValueFactory(new PropertyValueFactory<>("codi_solicitud"));
		tipus_solicitud.setCellValueFactory(new PropertyValueFactory<>("tipus_solicitud"));
		estat_solicitud.setCellValueFactory(new PropertyValueFactory<>("estat_solicitud"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		primer_cognom.setCellValueFactory(new PropertyValueFactory<>("primer_cognom"));
		segon_cognom.setCellValueFactory(new PropertyValueFactory<>("segon_cognom"));
		identficacio_RALC.setCellValueFactory(new PropertyValueFactory<>("identficacio_RALC"));
		tipus_alumne.setCellValueFactory(new PropertyValueFactory<>("tipus_alumne"));
		codi_centre_P1.setCellValueFactory(new PropertyValueFactory<>("codi_centre_P1"));
		nom_centre_P1.setCellValueFactory(new PropertyValueFactory<>("nom_centre_P1"));
		naturalesa_centre_P1.setCellValueFactory(new PropertyValueFactory<>("naturalesa_centre_P1"));
		municipi_centre_P1.setCellValueFactory(new PropertyValueFactory<>("municipi_centre_P1"));
		SSTT_centre_P1.setCellValueFactory(new PropertyValueFactory<>("SSTT_centre_P1"));
		codi_ensenyament_P1.setCellValueFactory(new PropertyValueFactory<>("codi_ensenyament_P1"));
		nom_ensenyament_P1.setCellValueFactory(new PropertyValueFactory<>("nom_ensenyament_P1"));
		codi_modalitat.setCellValueFactory(new PropertyValueFactory<>("codi_modalitat"));
		modalitat.setCellValueFactory(new PropertyValueFactory<>("modalitat"));
		curs_P1.setCellValueFactory(new PropertyValueFactory<>("curs_P1"));
		regim_P1.setCellValueFactory(new PropertyValueFactory<>("regim_P1"));
		torn_P1.setCellValueFactory(new PropertyValueFactory<>("torn_P1"));
		DNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
		NIE.setCellValueFactory(new PropertyValueFactory<>("NIE"));
		PASS.setCellValueFactory(new PropertyValueFactory<>("PASS"));
		TIS.setCellValueFactory(new PropertyValueFactory<>("TIS"));
		data_naixement.setCellValueFactory(new PropertyValueFactory<>("data_naixement"));
		sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
		nacionalitat.setCellValueFactory(new PropertyValueFactory<>("nacionalitat"));
		pais_naixement.setCellValueFactory(new PropertyValueFactory<>("pais_naixement"));
		municipi_naixement.setCellValueFactory(new PropertyValueFactory<>("municipi_naixement"));
		tipus_via.setCellValueFactory(new PropertyValueFactory<>("tipus_via"));
		nom_via.setCellValueFactory(new PropertyValueFactory<>("nom_via"));
		numero_via.setCellValueFactory(new PropertyValueFactory<>("numero_via"));
		altres_dades.setCellValueFactory(new PropertyValueFactory<>("altres_dades"));
		provincia_residencia.setCellValueFactory(new PropertyValueFactory<>("provincia_residencia"));
		municipi_residencia.setCellValueFactory(new PropertyValueFactory<>("municipi_residencia"));
		localitat_residencia.setCellValueFactory(new PropertyValueFactory<>("localitat_residencia"));
		CP.setCellValueFactory(new PropertyValueFactory<>("CP"));
		pais_residencia.setCellValueFactory(new PropertyValueFactory<>("pais_residencia"));
		telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		correu_electronic.setCellValueFactory(new PropertyValueFactory<>("correu_electronic"));
		tipus_doc_tutor_1.setCellValueFactory(new PropertyValueFactory<>("tipus_doc_tutor_1"));
		num_doc_tutor_1.setCellValueFactory(new PropertyValueFactory<>("num_doc_tutor_1"));
		nom_tutor_1.setCellValueFactory(new PropertyValueFactory<>("nom_tutor_1"));
		primer_cognom_tutor_1.setCellValueFactory(new PropertyValueFactory<>("primer_cognom_tutor_1"));
		segon_cognom_tutor_1.setCellValueFactory(new PropertyValueFactory<>("segon_cognom_tutor_1"));
		tipus_doc_tutor_2.setCellValueFactory(new PropertyValueFactory<>("tipus_doc_tutor_2"));
		num_doc_tutor_2.setCellValueFactory(new PropertyValueFactory<>("num_doc_tutor_2"));
		nom_tutor_2.setCellValueFactory(new PropertyValueFactory<>("nom_tutor_2"));
		primer_cognom_tutor_2.setCellValueFactory(new PropertyValueFactory<>("primer_cognom_tutor_2"));
		segon_cognom_tutor_2.setCellValueFactory(new PropertyValueFactory<>("segon_cognom_tutor_2"));
		codi_centre_proc.setCellValueFactory(new PropertyValueFactory<>("codi_centre_proc"));
		nom_centre_proc.setCellValueFactory(new PropertyValueFactory<>("nom_centre_proc"));
		codi_ensenyament_proc.setCellValueFactory(new PropertyValueFactory<>("codi_ensenyament_proc"));
		nom_ensenyament_proc.setCellValueFactory(new PropertyValueFactory<>("nom_ensenyament_proc"));
		curs_proc.setCellValueFactory(new PropertyValueFactory<>("curs_proc"));
		llengua_enten.setCellValueFactory(new PropertyValueFactory<>("llengua_enten"));
		religio.setCellValueFactory(new PropertyValueFactory<>("religio"));
		centre_assignat.setCellValueFactory(new PropertyValueFactory<>("centre_assignat"));
		
		for (Student i : studentsList) {
			
			tableid.getItems().add(i);
			
		}
				
		
	}
	
	@FXML
	private void addAlumns(ActionEvent event) throws IOException, InterruptedException{
		List<Student> students = tableid.getSelectionModel().getSelectedItems();
		
		ArrayList<Student> studentsToAdd = new ArrayList<Student>();
		
		for (Student student : students) {
			
			studentsToAdd.add(student);
			
		}
		
		String jsonString = new Gson().toJson(studentsToAdd);
		
		String responseBody = RequestUtils.httpPostRequest("/students/create", jsonString);
		
		if (responseBody.equals("Error")) {
			
			Alert alert = new Alert (AlertType.INFORMATION, "No se han agregado alumnos, ya estaban introducidos");
			
			alert.show();
			
		} else {
			
			Alert alert = new Alert (AlertType.INFORMATION, "Alumnos agregados correctamente");
			
			alert.show();
			
		}
		
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
		
		btnBack.getScene().getWindow().hide();
		btnSend.getScene().getWindow().hide();
		btnImportAlumns.getScene().getWindow().hide();
    	
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

}

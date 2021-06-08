package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

    @FXML
    private Label lblMenu;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnAddCourses;

    @FXML
    private Button btnAddAlumns;

    @FXML
    private Button btnViewAlumns;

    @FXML
    private Button btnViewCourses;
    
    @FXML
    private Button btnRequirements;
	
	@FXML
	void openAddCourses(ActionEvent event) throws IOException, InterruptedException {
		changeScene("AddCoursesView.fxml");
	}
	
	@FXML
	void openAddAlumns(ActionEvent event) throws IOException, InterruptedException {
		changeScene("AddStudentsView.fxml");
	}
	
	@FXML
	void openViewAlumns(ActionEvent event) throws IOException, InterruptedException {
		changeScene("ConsultStudentsView.fxml");
	}
	
	@FXML
	void openViewCourses(ActionEvent event) throws IOException, InterruptedException {
		changeScene("ConsultCoursesView.fxml");
	}
	
	@FXML
	void openAddRequirements(ActionEvent event) throws IOException, InterruptedException {
		changeScene("ProfileRequirementsFormView.fxml");
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
			
			btnAddCourses.getScene().getWindow().hide();
			btnAddAlumns.getScene().getWindow().hide();
			btnViewAlumns.getScene().getWindow().hide();
	    }

}

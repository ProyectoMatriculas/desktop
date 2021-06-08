package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Course;
import model.Module;
import model.Student;
import model.Uf;
import util.JsonUtils;
import util.RequestUtils;

public class ConsultStudentsController implements Initializable {
	
	ArrayList<Course> coursesList;
	ArrayList<Student> studentsList;

    @FXML
    private ChoiceBox<Course> choiceBoxCourse;

    @FXML
    private ListView<Student> lvStudents;

    @FXML
    void exit(ActionEvent event) {
    	
    	System.exit(0);

    }
    
    @FXML
	private void backMenu(ActionEvent event) throws IOException, InterruptedException {
		changeScene("MenuView.fxml");
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
						
			coursesList = JsonUtils.generateCourses();
			
			for (Course course : coursesList) {
				
				choiceBoxCourse.getItems().add(course);
				
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @FXML
	 void selectCourse(ActionEvent event) {
	    	
		 try {
			 
			lvStudents.getItems().clear();
			 
			Course selectedCourse = choiceBoxCourse.getValue();
			 
			String jsonString = RequestUtils.getByParameterRequest("/students", "CourseCode", selectedCourse.getCODI_CICLE_FORMATIU());
			 
			studentsList = JsonUtils.generateStudents(jsonString);
			
			for (Student s : studentsList) {
				
				lvStudents.getItems().add(s);
				
			}
			  
		 } catch (Exception e) {
			
			 e.printStackTrace();
			 
		}
	    	
	 }
	 
	 void changeScene(String nextScene) throws IOException {
	    	
		Stage stage = new Stage();
				
		Parent root = FXMLLoader.load(LoginController.class.getResource("../view/" + nextScene));
				
		Scene scene = new Scene(root);
				
		stage.initStyle(StageStyle.DECORATED.UNDECORATED);
			
		stage.setScene(scene);
		stage.show();
				
		choiceBoxCourse.getScene().getWindow().hide();
		   	
	}
		
}

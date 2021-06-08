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
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Course;
import model.Module;
import model.Uf;
import util.JsonUtils;
import util.RequestUtils;

public class ConsultCoursesController implements Initializable {
	
	ArrayList<Course> coursesList;

    @FXML
    private ChoiceBox<Course> choiceBoxCourse;

    @FXML
    private Accordion accModule;

    @FXML
    void exit(ActionEvent event) {
    	
    	System.exit(0);

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
	private void backMenu(ActionEvent event) throws IOException, InterruptedException {
		changeScene("MenuView.fxml");
	}

    @FXML
    void selectCourse(ActionEvent event) {
    	
    	accModule.getPanes().clear();
    	
    	Course selectedCourse = choiceBoxCourse.getValue();
    	
    	if (selectedCourse != null) {
    		
    		for (Module module : selectedCourse.getModules()) {
				    			
    			AnchorPane anchorPane = new AnchorPane();
				
				TitledPane titledPane = new TitledPane();
				
				titledPane.setText(module.getModuleName());
				
				ListView<Uf> ufList = new ListView<Uf>();
				
				for (Uf uf : module.getModuleUfs()) {
					
					ufList.getItems().add(uf);
					
				}
				
				anchorPane.getChildren().add(ufList);
				titledPane.setContent(anchorPane);
				titledPane.setPrefWidth(1000);
				accModule.getPanes().add(titledPane);
    			
			}
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.INFORMATION, "No has seleccionado ningun curso");
    		alert.show();
    		
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

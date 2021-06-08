package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.RequerimentsProfile;
import util.RequestUtils;

public class ProfileRequirementsFormController implements Initializable {
		
	@FXML
	private Button btnAddRequirements;
	
	@FXML
	private Button btnSend;
	
	@FXML
	private TextArea txtAreaDescription;
	
	@FXML
	private TextField txtFieldName;
	
	@FXML
    private VBox vboxReqList;
	
	private ArrayList<TextField> vboxList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		vboxReqList.setSpacing(5);
		vboxList = new ArrayList<TextField>();
		addTextFields();
		
	}

	
	
	@FXML
	void addTextFields() {
		for (int i = 0; i < 3; i++)
    	{
    		TextField txt = new TextField();
    		vboxList.add(txt);
    		vboxReqList.getChildren().add(txt);    		
    	}
	}
	
	@FXML
	void send (ActionEvent event) throws IOException, InterruptedException {
		String name = txtFieldName.getText();
		String description = txtAreaDescription.getText();
		ArrayList<String> listRequirements = new ArrayList<String>();
		for(TextField txtField : vboxList) {
			String sTxt = txtField.getText();
			if(sTxt != null && !sTxt.isBlank()) {
				listRequirements.add(sTxt);
			}
		}
		
		RequerimentsProfile rp = new RequerimentsProfile(name, description, listRequirements);
		
		String jsonString = new Gson().toJson(rp);
		
		String responseBody = RequestUtils.httpPostRequest("/requirements/create", jsonString);
			
		if (responseBody.equals("Error")) {
				
			Alert alert = new Alert (AlertType.INFORMATION, "No se ha insertado el perfil de requerimientos, ya habia uno con ese nombre");
				
			alert.show();
				
		} else {
				
			Alert alert = new Alert (AlertType.INFORMATION, "Perfil de requerimientos insertado correctamente");
				
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
		
    	
    }





	
}

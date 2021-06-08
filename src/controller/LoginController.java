package controller;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.RequestUtils;

public class LoginController {
	
	final String endpoint = "/login/admin";
	
    @FXML
    private TextField fieldEmail;

    @FXML
    private PasswordField fieldPassword;
    
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnExit;


    @FXML
    void exit(ActionEvent event) {
    	
    	System.exit(0);

    }

    @FXML
    void login(ActionEvent event) throws IOException, InterruptedException {
    	
    	System.out.println(fieldEmail.getText());
    	
    	if (fieldEmail.getText().equalsIgnoreCase("") || fieldPassword.getText().equalsIgnoreCase("")) {
    		
    		Alert alert = new Alert(AlertType.ERROR, "There are empty fields");
    		
    		alert.showAndWait();
    		
    	} else {
    		    			
    		JsonObject userData = new JsonObject();
    			
    		userData.addProperty("email", fieldEmail.getText());
    		userData.addProperty("password", fieldPassword.getText());
    			
    		String requestBody = new Gson().toJson(userData);
    		
    		String responseBody = RequestUtils.httpPostRequest(endpoint, requestBody);
    		
    		if (responseBody == "Error") {
    			
    			Alert alert = new Alert(AlertType.ERROR, "Invalid credentials");
        		
        		alert.show();
        		
        	} else {
        		
        		Main.token = responseBody;
        		
        		changeScene("MenuView.fxml");
        		
        	}
    		
    	}

    }
    
    void changeScene(String nextScene) throws IOException {
    	
    	Stage stage = new Stage();
		
		Parent root = FXMLLoader.load(LoginController.class.getResource("../view/" + nextScene));
		
		Scene scene = new Scene(root);
		
		stage.initStyle(StageStyle.DECORATED.UNDECORATED);
	
		stage.setScene(scene);
		stage.show();
		
		btnLogin.getScene().getWindow().hide();
    	
    }

}

package application;

import java.awt.Button;
import java.io.BufferedReader;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import javax.net.ssl.HttpsURLConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	
	static Stage loginStage;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField emailfield;
	
	@FXML
	private PasswordField passfield;
	
	@FXML
	private Button btnLogin;	
	@FXML
	private void login(ActionEvent event) {
		
		String res = "";
		String password = this.passfield.getText();
		// String password = "hola123";
		// String email = "Alberto@gmail.com"; 				
		 String email = emailfield.getText();
		try {
			URL url = new URL("https://morning-peak-25234.herokuapp.com/login/admin?email=" + email +"&password=" + password);
			URLConnection conexion = (URLConnection) url.openConnection();
			InputStream is = conexion.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			char[] buffer = new char[2000];
			int leido;
			while ((leido = br.read(buffer)) > 0) {
				res = new String(buffer, 0, leido);
	         }
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(res);
			
			String status = (String) json.get("status");
	        
			if(status.equals("OK")) {
				try {
					  System.out.println("Hola");
					  root = FXMLLoader.load(getClass().getResource("AddCycles.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
					  
				    } catch (IOException e) {
				    	e.printStackTrace();
				    }
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Login failed");
				alert.setContentText("El usuario o la contraseña son incorrectos");

				alert.showAndWait();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		  try {
			  System.out.println("Hola");
			  root = FXMLLoader.load(getClass().getResource("AddCycles.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		    */
	}	
		
	

}

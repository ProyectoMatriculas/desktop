package application;

import java.awt.Button;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class CyclesController {
	
private ArrayList<String> ciclos = new ArrayList<String>();
	
	@FXML
	private Button buttonadd;
	
	@FXML
	private TableView<ArrayList<String>> table;

	@FXML
	private void search(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		// Obtener la imagen seleccionada
		File file = fileChooser.showOpenDialog(null);	
		
		ArrayList<String[]> lines = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			while (br.ready()) {
				lines.add(br.readLine().replaceAll("\"+", "").split(","));
			}
			br.close();
			
			for(int i = 0; i < lines.size(); i++) {
				 //if (!lines.get(i)[0].equals(lines.get(i + 1)[0])) {
			    ciclos.add(lines.get(i)[0] + " " + lines.get(i)[1] + " " + lines.get(i)[2] + " " + lines.get(i)[3] + " " + lines.get(i)[4]
			    		+ " " + lines.get(i)[5]); /* + " " + lines.get(i)[6]);  + " " + lines.get(i)[7] + " " + lines.get(i)[8] + " " + lines.get(i)[9] + " " 
			    		+ lines.get(i)[10] + " " + lines.get(i)[11] + " " + lines.get(i)[12] + " " + lines.get(i)[13] + " " + lines.get(i)[14] + " "
			    		+ lines.get(i)[15] + " " + lines.get(i)[16] + " " + lines.get(i)[17] + " " + lines.get(i)[18] + " " + lines.get(i)[6] + " ");
			    		*/
			    System.out.println(ciclos.get(i));
			    //table.getItems().add(ciclos);
				 //}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha seleccionado ningun archivo o bien el archivo seleccionado no tiene un formato correcto.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("No se ha seleccionado ningun archivo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}


			
		}
	
		
	}



package application;

import java.awt.Button;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

public class AddCyclesController {
	
	private ArrayList<String> ciclos;
	
	@FXML
	private Button buttonadd;
	
	@FXML
	private TableView table;

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
		} catch (FileNotFoundException e) {
			System.out.println("No se ha seleccionado ningun archivo o bien el archivo seleccionado no tiene un formato correcto.");
		} catch (NullPointerException e) {
			System.out.println("No se ha seleccionado ningun archivo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}
}

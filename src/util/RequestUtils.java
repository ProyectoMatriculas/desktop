package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import application.Main;

public class RequestUtils {
	
	public static String api = "https://matriculas-api.herokuapp.com";
//	public static String api = "http://localhost:5000";
	
	public static String httpPostRequest(String endPoint, String jsonData) throws IOException, InterruptedException {
		
		URI uri = URI.create(api + endPoint);
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(uri)
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("access-token", Main.token)
				.POST(BodyPublishers.ofString(jsonData))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		
		if (response.statusCode() == 200) {
			
			return response.body();
			
		} else {
			
			return "Error";
			
		}
		
	}
	
	public static String getAllRequest(String endpoint) throws IOException, InterruptedException {
		
		URI uri = URI.create(api + endpoint + "/getAll");
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(uri)
				.header("access-token", Main.token)
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		if (response.statusCode() == 200) {
			
			return response.body();
			
		} else {
			
			return "Error";
			
		}
		
	}
	
	public static String getByParameterRequest(String endpoint, String parameter, String value) throws IOException, InterruptedException {
		
		String uriWithSpaces = api + endpoint + "/getBy" + parameter + "?" + parameter + "=" + value;
		
		URI uri = URI.create(uriWithSpaces.toString().replace(" ", "%20"));
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(uri)
				.header("access-token", Main.token)
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		if (response.statusCode() == 200) {
			
			return response.body();
			
		} else {
			
			return "Error";
			
		}
		
	}
	
	
}

package api;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javaBeans.Ville;

public class APIResponse {
	
	public static ArrayList<Ville> getAPIResponse(String url, String requestMethod) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		JSONObject returnedObject = null;
		try {
			HttpURLConnection connection;
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod(requestMethod);
			
			InputStream is = connection.getInputStream();
			BufferedReader sr = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder rsb = new StringBuilder();
			
			String tmp;
			
			while((tmp = sr.readLine()) != null) {
				rsb.append(tmp);
			}
			String stringJson = rsb.toString();
			returnedObject = new JSONObject(stringJson);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		if(requestMethod.equals("GET")) {
			return APIResponse.translateAPIResponse(returnedObject);
		}
		else {
			return null;
		}
		
	}

	private static ArrayList<Ville> translateAPIResponse(JSONObject returnedObject) {
		// TODO Auto-generated method stub
		ArrayList<Ville> villes = new ArrayList<Ville>();
		JSONArray resultsArray = returnedObject.getJSONArray("ville");
		for (int i = 0; i < resultsArray.length(); i++) {
			villes.add(new Ville(resultsArray.getJSONObject(i)));
		}
		return villes;
	}
	public static void putAPIResponse(String url, String requestMethod) {
		try {
			HttpURLConnection connection;
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod(requestMethod);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

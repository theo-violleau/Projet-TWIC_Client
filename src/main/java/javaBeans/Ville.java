package javaBeans;

import org.json.JSONObject;
import java.lang.Math;
import java.util.ArrayList;

public class Ville {
	
	
	private String code_commune, nom_commune,code_postale, libelle, ligne5, longitude, latitude;

	public Ville(String code_commune, String nom_commune, String code_postale, String libelle, String ligne5,
			String longitude, String latitude) {
		this.code_commune = code_commune;
		this.nom_commune = nom_commune;
		this.code_postale = code_postale;
		this.libelle = libelle;
		this.ligne5 = ligne5;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Ville (JSONObject json) {
		this(json.getString("code_commune"), json.getString("nom_commune"), json.getString("code_postale"),
				json.getString("libelle"), json.getString("ligne5"), json.getString("latitude"),
				json.getString("longitude"));
	}

	public String getCode_commune() {
		return code_commune;
	}

	public void setCode_commune(String code_commune) {
		this.code_commune = code_commune;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	public static Ville fetchCity(ArrayList<Ville> villes, String nom_ville ){
		Ville ville = null;
		for(Ville v : villes) {
			if(v.getNom_commune().equals(nom_ville)) {
				 ville = new Ville(v.code_commune,v.nom_commune,v.code_postale,v.libelle,v.ligne5,v.longitude,v.latitude);
			}
		}
		return ville;
		
	}
	
//	Fonctions pour le calcul de la distance
	
	public double distance(Ville ville) {
		double lat1 = Double.parseDouble(this.getLatitude());
		double lon1 = Double.parseDouble(this.getLongitude());
		double lat2 = Double.parseDouble(ville.getLatitude());
		double lon2 = Double.parseDouble(ville.getLongitude());
		double theta = lon1 - lon2; double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta)); 
		dist = Math.acos(dist); dist = rad2deg(dist); dist = dist * 60 * 1.1515; 
		dist = dist * 1.609344; 
		return dist;
	}
	
	private double deg2rad(double deg) { 
		return (deg * Math.PI / 180.0); 
		} 
	
	private double rad2deg(double rad) { 
		return (rad * 180.0 / Math.PI); 
		}

	public String toURLParameters() {
		String tmp = "?Code_commune_INSEE=%s&Nom_commune=%s&Code_postal=%s&Libelle_acheminement=%s&Ligne_5=%s&Latitude=%s&Longitude=%s";
		return String.format(tmp, code_commune, nom_commune, code_postale, libelle, ligne5, latitude, longitude).replaceAll(" ", "+");
	}

	
}

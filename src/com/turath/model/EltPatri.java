package com.turath.model;

import java.util.List;

public class EltPatri 
{
	private int idEltPatri;
	private String descEltPatri;
	private float altitude;
	private float longitude;
	private String dateConstruction;
	private String périodeConstruction;
	private List<String> appels;
	private List<String> images;
	private int valide;
	private int supprime;
	
	public EltPatri() {
		
	}
	public EltPatri(int idEltPatri,String descEltPatri,float altitude,
			float longitude, String dateConstruction,String périodeConstruction, List<String> appels, 
			List<String> images, int valide, int supprime)
	{
		this.idEltPatri=idEltPatri;
		this.descEltPatri= descEltPatri;
		this.altitude = altitude;
		this.longitude = longitude;
		this.dateConstruction = dateConstruction;
		this.périodeConstruction = périodeConstruction;
		this.appels =appels;
		this.images = images;
		this.valide = valide;
		this.supprime = valide;
	}

	public List<String> getAppels() {
		return appels;
	}


	public void setAppels(List<String> appels) {
		this.appels = appels;
	}


	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public int getIdEltPatri() {
		return idEltPatri;
	}

	public void setIdEltPatri(int idEltPatri) {
		this.idEltPatri = idEltPatri;
	}

	public String getDescEltPatri() {
		return descEltPatri;
	}

	public void setDescEltPatri(String descEltPatri) {
		this.descEltPatri = descEltPatri;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getDateConstruction() {
		return dateConstruction;
	}

	public void setDateConstruction(String dateConstruction) {
		this.dateConstruction = dateConstruction;
	}

	public String getPériodeConstruction() {
		return périodeConstruction;
	}

	public void setPériodeConstruction(String périodeConstruction) {
		this.périodeConstruction = périodeConstruction;
	}
	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public int getSupprime() {
		return supprime;
	}

	public void setSupprime(int supprime) {
		this.supprime = supprime;
	}
	
}

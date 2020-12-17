package com.turath.model;

import java.util.Map;

public class EltPatriGestion {
	

	private int idEltPatri;
	
	private String descEltPatri;
	private String sourcedesc;
	
	private float altitude;
	private float longitude;
	private String sourcealtlong;
	
	private String dateConstruction;
	private String périodeConstruction;
	private String sourceDatePériode;
	
	private Map<String,String> appels;
	private Map<String,String> images;
	
	private int valide;
	private int supprime;
	
	public EltPatriGestion(int idEltPatri,String descEltPatri,String sourceDesc, float altitude, float longitude,String sourcealtlong, String dateConstruction,String périodeConstruction,String sourceDatePériode, Map<String,String> appels, 
Map<String,String> images, int valide, int supprime)
	{
		this.idEltPatri=idEltPatri;
		
		this.descEltPatri= descEltPatri;
		this.sourcedesc= sourceDesc;
		
		this.altitude = altitude;
		this.longitude = longitude;
		this.sourcealtlong= sourcealtlong;
		
		this.dateConstruction = dateConstruction;
		this.périodeConstruction = périodeConstruction;
		this.sourceDatePériode = sourceDatePériode;
		
		this.appels =appels;
		this.images = images;
		
		this.valide = valide;
		this.supprime = supprime;
	}
	

	public String getSourcedesc() {
		return sourcedesc;
	}


	public void setSourcedesc(String sourcedesc) {
		this.sourcedesc = sourcedesc;
	}


	public String getSourcealtlong() {
		return sourcealtlong;
	}


	public void setSourcealtlong(String sourcealtlong) {
		this.sourcealtlong = sourcealtlong;
	}


	public String getSourceDatePériode() {
		return sourceDatePériode;
	}


	public void setSourceDatePériode(String sourceDatePériode) {
		this.sourceDatePériode = sourceDatePériode;
	}


	public Map<String,String> getAppels() {
		return appels;
	}


	public void setAppels(Map<String,String> appels) {
		this.appels = appels;
	}


	public Map<String,String> getImages() {
		return images;
	}


	public void setImages(Map<String,String> images) {
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

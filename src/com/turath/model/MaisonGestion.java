package com.turath.model;

import java.util.Map;

public class MaisonGestion extends EltPatriGestion
{
	

	private String surfaceSol;
	private String surfaceMaison;
	private String sourceSurface;

	public MaisonGestion(int idEltPatri,String descEltPatri,String sourceDesc,float altitude,
			float longitude,String sourcealtlong, String dateConstruction,String périodeConstruction, 
			String sourceDatePériode, String surfaceSol, String surfaceMaison, String sourceSurface, Map<String,String> appels, 
			Map<String,String> images,int valide, int supprime)
	{
		
		super(idEltPatri,descEltPatri,sourceDesc,altitude,
				longitude,sourcealtlong, dateConstruction,périodeConstruction,sourceDatePériode,appels, 
				images, valide, supprime);
		
		this.surfaceSol= surfaceSol;
		this.surfaceMaison = surfaceMaison;
		this.sourceSurface= sourceSurface;
		
	}

	
	
	public String getSourceSurface() {
		return sourceSurface;
	}



	public void setSourceSurface(String sourceSurface) {
		this.sourceSurface = sourceSurface;
	}



	public String getSurfaceSol() {
		return surfaceSol;
	}

	public void setSurfaceSol(String surfaceSol) {
		this.surfaceSol = surfaceSol;
	}

	public String getSurfaceMaison() {
		return surfaceMaison;
	}

	public void setSurfaceMaison(String surfaceMaison) {
		this.surfaceMaison = surfaceMaison;
	}
	
	

}

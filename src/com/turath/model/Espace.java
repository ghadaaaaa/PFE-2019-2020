package com.turath.model;

import java.util.List;

public class Espace extends EltPatri
{
	private String typeEspace;
	
	public Espace(int idEltPatri,String descEltPatri,float altitude,
			float longitude, String dateConstruction,String périodeConstruction, 
			String typeEspace, List<String> appels, List<String> images, int valide, int supprime)
	{
		super(idEltPatri,descEltPatri,altitude,longitude,
				dateConstruction,périodeConstruction, appels, images, valide, supprime);
		this.typeEspace=typeEspace;
	
	}

	public String getTypeEspace() {
		return typeEspace;
	}

	public void setTypeEspace(String typeEspace) {
		this.typeEspace = typeEspace;
	}
	
	
}

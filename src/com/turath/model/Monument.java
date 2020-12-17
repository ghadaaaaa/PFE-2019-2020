package com.turath.model;
import java.util.List;

public class Monument extends EltPatri
{
	private String typeMo;
	
	public Monument(int idEltPatri,String descEltPatri,float altitude,
			float longitude, String dateConstruction,String périodeConstruction, String typeMo, List<String> appels, 
			List<String> images, int valide, int supprime)
	{
		super(idEltPatri,descEltPatri,altitude,longitude,
				dateConstruction,périodeConstruction, appels, images, valide, supprime);
		this.typeMo=typeMo;
	
	}

	public String getTypeMo() {
		return typeMo;
	}

	public void setTypeMo(String typeMo) {
		this.typeMo = typeMo;
	}

	
}

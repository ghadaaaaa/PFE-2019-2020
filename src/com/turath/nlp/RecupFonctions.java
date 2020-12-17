package com.turath.nlp;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.turath.model.Fonction;

public class RecupFonctions {

	private List<Fonction> fonctions =new ArrayList<Fonction>();

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	
	
	public void recup_fonctions(JsonArray jsonFonctions)
	{   try {
		if (jsonFonctions.isJsonArray()) 
        {   
            for(int i = 0; i< jsonFonctions.size(); i++) 
            {
            	 JsonObject elt =(JsonObject) jsonFonctions.get(i);
            	 if (elt.isJsonObject()) 
            	 { 
            		 int idFonction =elt.get("idFonction").getAsInt();
            		 String fct = elt.get("fonction").getAsString();
            		 String aspectFonction = elt.get("aspectFonction").getAsString();
            	     Fonction fonction = new Fonction(idFonction, fct, aspectFonction);
            	     this.fonctions.add(fonction);
            	 }
	        }
        }
    }catch(Exception e) {e.printStackTrace();}
	
	}

	
	
}

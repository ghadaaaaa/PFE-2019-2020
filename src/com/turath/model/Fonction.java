package com.turath.model;

public class Fonction {
    private int idFonction;
    private String fonction;
    private String typeFonction;
    
    
	public Fonction(int idFonction, String fonction, String typeFonction) {
		super();
		this.idFonction = idFonction;
		this.fonction = fonction;
		this.typeFonction = typeFonction;
	}
	
	
	public int getIdFonction() {
		return idFonction;
	}
	public void setIdFonction(int idFonction) {
		this.idFonction = idFonction;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getTypeFonction() {
		return typeFonction;
	}
	public void setTypeFonction(String typeFonction) {
		this.typeFonction = typeFonction;
	}
    
    
}

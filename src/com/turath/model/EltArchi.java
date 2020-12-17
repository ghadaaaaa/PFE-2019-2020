package com.turath.model;

import java.util.List;

public class EltArchi {
	private int idEltArchi;
	private String nomEltArchi;
	private String appelTradi;
	private String descEltArchi;
	private String typeEltArchi;
	private List<Fonction> fonctions;
	private List<Source> sources;
	private List<Image> images;

	
	/******CONSTRUCTOR**********/
	
	public EltArchi(int idEltArchi, String nomEltArchi, String appelTradi, String descEltArchi, String typeEltArchi,
			List<Fonction> fonctions, List<Source> sources, List<Image> images) {
		super();
		this.idEltArchi = idEltArchi;
		this.nomEltArchi = nomEltArchi;
		this.appelTradi = appelTradi;
		this.descEltArchi = descEltArchi;
		this.typeEltArchi = typeEltArchi;
		this.fonctions = fonctions;
		this.sources = sources;
		this.images = images;
	}
	
	/*****GETTERS AND SETTERS*********/
	
	public int getIdEltArchi() {
		return idEltArchi;
	}
	
	public void setIdEltArchi(int idEltArchi) {
		this.idEltArchi = idEltArchi;
	}
	public String getNomEltArchi() {
		return nomEltArchi;
	}
	public void setNomEltArchi(String nomEltArchi) {
		this.nomEltArchi = nomEltArchi;
	}
	public String getAppelTradi() {
		return appelTradi;
	}
	public void setAppelTradi(String appelTradi) {
		this.appelTradi = appelTradi;
	}
	public String getDescEltArchi() {
		return descEltArchi;
	}
	public void setDescEltArchi(String descEltArchi) {
		this.descEltArchi = descEltArchi;
	}
	public String getTypeEltArchi() {
		return typeEltArchi;
	}
	public void setTypeEltArchi(String typeEltArchi) {
		this.typeEltArchi = typeEltArchi;
	}
	public List<Fonction> getFonctions() {
		return fonctions;
	}
	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	public List<Source> getSources() {
		return sources;
	}
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}

	

}

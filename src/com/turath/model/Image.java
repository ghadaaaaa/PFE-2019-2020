package com.turath.model;

public class Image {

	private int idImage;
	private String image;
	private String legende;
	
	
	
	public Image(int idImage, String image, String legende) {
		super();
		this.idImage = idImage;
		this.image = image;
		this.legende = legende;
	}
	
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLegende() {
		return legende;
	}
	public void setLegende(String legende) {
		this.legende = legende;
	}
	
}

package com.turath.model;

public class Source {

	private int idSource;
	private String source;
	private String typeSource;
	

	public Source(int idSource, String source, String typeSource) {
		super();
		this.idSource = idSource;
		this.source = source;
		this.typeSource = typeSource;
	}
	
	public int getIdSource() {
		return idSource;
	}
	public void setIdSource(int idSource) {
		this.idSource = idSource;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTypeSource() {
		return typeSource;
	}
	public void setTypeSource(String typeSource) {
		this.typeSource = typeSource;
	}
	
	
	
}

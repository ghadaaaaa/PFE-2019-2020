package com.turath.nlp;
import com.turath.model.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RecupEltsArchi {
	
	private List<EltArchi> eltsArchi = new ArrayList<EltArchi>();

	public List<EltArchi> getEltsArchi() {
		return eltsArchi;
	}
	
	public void setEltsArchi(List<EltArchi> eltsArchi) {
		this.eltsArchi = eltsArchi;
	}

    private void addMaisonsWestDar(List<String> maisonsWestDar)
    {
    	maisonsWestDar.add("maison à west dar");
    	maisonsWestDar.add("maison à west eddar");
    	maisonsWestDar.add("maison à west el dar");
    	maisonsWestDar.add("maison à patio");
    }
    private void addMaisonsAlawi(List<String> maisonsAlawi)
    {
    	maisonsAlawi.add("maison alawi");
    	maisonsAlawi.add("maison alwi");
    }
    
    private void addMaisonsChbek(List<String> maisonsChbek)
    {
    	maisonsChbek.add("maison à chbek");
    	maisonsChbek.add("maison à shbek");
    	maisonsChbek.add("maison à shebek");
    }
    


	public void recup_elts_archi(String typeMaison)
 	{
         HttpURLConnection conn = null;
         DataOutputStream os = null;   
         List<String> maisonsWestDar = new ArrayList<String>();
    	 List<String> maisonsAlawi = new ArrayList<String>();
    	 List<String> maisonsChbek = new ArrayList<String>();
         addMaisonsWestDar(maisonsWestDar); 
         addMaisonsChbek(maisonsChbek); 
         addMaisonsAlawi(maisonsAlawi);
         if (maisonsAlawi.contains(typeMaison.toLowerCase()) || maisonsWestDar.contains(typeMaison.toLowerCase()) || maisonsChbek.contains(typeMaison.toLowerCase()))
         {
         try{
             URL url = new URL("http://127.0.0.1:5000/maisonCat/"); //important to add the trailing slash after add
             if (maisonsWestDar.contains(typeMaison.toLowerCase()))
             {
            	String westDar = "westDar";
            	String[] inputData = {"{\"typeMaison\":\""+westDar+"\"}"};
        		for(String input: inputData){
                    byte[] postData = input.getBytes(StandardCharsets.UTF_8);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty( "charset", "utf-8");
                    conn.setRequestProperty("Content-Length", Integer.toString(input.length()));
                    os = new DataOutputStream(conn.getOutputStream());
                    os.write(postData);
                    os.flush();

                    if (conn.getResponseCode() != 200) 
                    {
                        throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    
                    String output;
                    String json="";
                    while ((output = br.readLine() )!= null) {	              	
                        json= json+output;                 
                    }
                    System.out.println(json); 
                   
                    try {

        			JsonParser parser = new JsonParser();
                    JsonElement element = parser.parse(json);
                    if (element.isJsonObject()) {
                   	 JsonObject results = element.getAsJsonObject();
                        JsonArray array = results.get("results").getAsJsonArray();
                    if (array.isJsonArray()) 
                    {   
                   	 
                        for(int index = 0; index < array.size(); index++) 
                        {
                       	 JsonObject elt =(JsonObject) array.get(index);
                       	 if (elt.isJsonObject()) {                   		 
                       	    /****Ints andStrings*****/
                       	 	int idEltArchi =elt.get("idEltArchi").getAsInt();
                       	 	
                       	 	String nomEltArchi= elt.get("nomEltArchi").getAsString();
                       	 	String appelTradi= elt.get("appelTradi").getAsString();
                       	 	String descEltArchi = elt.get("descEltArchi").getAsString();
                       	 	String typeEltArchi = elt.get("typeEltArchi").getAsString();
                       	 	
                       		/*****Arrays*****/
                       	 	JsonArray jsonImages= elt.get("images").getAsJsonArray();
                       	 	RecupImages recupImages = new RecupImages();
                       	 	recupImages.recup_images(jsonImages);
                       	 	List<Image> images = recupImages.getImages();
                       	 	
                       	 	JsonArray jsonSources= elt.get("sources").getAsJsonArray();
                       	 	RecupSources recupSources = new RecupSources();
                       	 	recupSources.recup_sources(jsonSources);
                       	 	List<Source> sources = recupSources.getSources();
                       	 	
                       	 	JsonArray jsonFonctions= elt.get("fonctions").getAsJsonArray();
                       	 	RecupFonctions recupFonctions = new RecupFonctions();
                       	 	recupFonctions.recup_fonctions(jsonFonctions);
                       	 	List<Fonction> fonctions = recupFonctions.getFonctions();
                       	 
                       	 	
                       	 	
                       	 	EltArchi eltArchi= new EltArchi(idEltArchi, nomEltArchi, appelTradi, descEltArchi, typeEltArchi, fonctions, sources, images);
                       	    this.eltsArchi.add(eltArchi);
                       	 	
                       	 }
                        }
                                        	 
                    }
                    }
                    }         
                    catch(Exception e) {e.printStackTrace();}

                    conn.disconnect();
                }
             }
             
             
             

             else if (maisonsAlawi.contains(typeMaison.toLowerCase()))
             {
            	 String alawi = "alawi";
            	 String[] inputData = {"{\"typeMaison\":\""+alawi+"\"}"};
         		for(String input: inputData){
                    byte[] postData = input.getBytes(StandardCharsets.UTF_8);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty( "charset", "utf-8");
                    conn.setRequestProperty("Content-Length", Integer.toString(input.length()));
                    os = new DataOutputStream(conn.getOutputStream());
                    os.write(postData);
                    os.flush();

                    if (conn.getResponseCode() != 200) 
                    {
                        throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    
                    String output;
                    String json="";
                    while ((output = br.readLine() )!= null) {	              	
                        json= json+output;                 
                    }
                    System.out.println(json); 
                   
                    try {

        			JsonParser parser = new JsonParser();
                    JsonElement element = parser.parse(json);
                    if (element.isJsonObject()) {
                   	 JsonObject results = element.getAsJsonObject();
                        JsonArray array = results.get("results").getAsJsonArray();
                    if (array.isJsonArray()) 
                    {   
                   	 
                        for(int index = 0; index < array.size(); index++) 
                        {
                       	 JsonObject elt =(JsonObject) array.get(index);
                       	 if (elt.isJsonObject()) {                   		 
                       	    /****Ints andStrings*****/
                       	 	int idEltArchi =elt.get("idEltArchi").getAsInt() +1000;
                       	 	
                       	 	String nomEltArchi= elt.get("nomEltArchi").getAsString();
                       	 	String appelTradi= elt.get("appelTradi").getAsString();
                       	 	String descEltArchi = elt.get("descEltArchi").getAsString();
                       	 	String typeEltArchi = elt.get("typeEltArchi").getAsString();
                       	 	
                       		/*****Arrays*****/
                       	 	JsonArray jsonImages= elt.get("images").getAsJsonArray();
                       	 	RecupImages recupImages = new RecupImages();
                       	 	recupImages.recup_images(jsonImages);
                       	 	List<Image> images = recupImages.getImages();
                       	 	for (int i =0 ; i<images.size(); i++)
                       	 	{
                       	 		int idImg = images.get(i).getIdImage()+1000;
                       	 		Image img = new Image (idImg, images.get(i).getImage(), images.get(i).getLegende());
                       	     	images.set(i, img);
                       	 	}
                       	 	
                       	 	JsonArray jsonSources= elt.get("sources").getAsJsonArray();
                       	 	RecupSources recupSources = new RecupSources();
                       	 	recupSources.recup_sources(jsonSources);
                       	 	List<Source> sources = recupSources.getSources();
                        	for (int i =0 ; i<sources.size(); i++)
                    	 	{
                    	 		int idSrc = sources.get(i).getIdSource()+1000;
                    	 		Source src = new Source(idSrc, sources.get(i).getSource(), sources.get(i).getTypeSource());
                    	 		sources.set(i, src);
                    	 	}
                        	 
                       	 	JsonArray jsonFonctions= elt.get("fonctions").getAsJsonArray();
                       	 	RecupFonctions recupFonctions = new RecupFonctions();
                       	 	recupFonctions.recup_fonctions(jsonFonctions);
                       	 	List<Fonction> fonctions = recupFonctions.getFonctions();
                        	for (int i =0 ; i<fonctions.size(); i++)
                    	 	{
                    	 		int idFct = fonctions.get(i).getIdFonction()+1000;
                    	 		Fonction fct = new Fonction(idFct, fonctions.get(i).getFonction(), fonctions.get(i).getTypeFonction());
                    	 		fonctions.set(i, fct);
                    	 	}
                       	 	      	 	
                       	 	EltArchi eltArchi= new EltArchi(idEltArchi, nomEltArchi, appelTradi, descEltArchi, typeEltArchi, fonctions, sources, images);
                       	    this.eltsArchi.add(eltArchi);
                       	 	
                       	 }
                        }
                                        	 
                    }
                    }
                    }         
                    catch(Exception e) {e.printStackTrace();}

                    conn.disconnect();
                }
             }
             else if (maisonsChbek.contains(typeMaison.toLowerCase()))
             {
            	 String chbek = "chbek";
            	 String[] inputData = {"{\"typeMaison\":\""+chbek+"\"}"};
          		for(String input: inputData){
                    byte[] postData = input.getBytes(StandardCharsets.UTF_8);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty( "charset", "utf-8");
                    conn.setRequestProperty("Content-Length", Integer.toString(input.length()));
                    os = new DataOutputStream(conn.getOutputStream());
                    os.write(postData);
                    os.flush();

                    if (conn.getResponseCode() != 200) 
                    {
                        throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    
                    String output;
                    String json="";
                    while ((output = br.readLine() )!= null) {	              	
                        json= json+output;                 
                    }
                    System.out.println(json); 
                   
                    try {

        			JsonParser parser = new JsonParser();
                    JsonElement element = parser.parse(json);
                    if (element.isJsonObject()) {
                   	 JsonObject results = element.getAsJsonObject();
                        JsonArray array = results.get("results").getAsJsonArray();
                    if (array.isJsonArray()) 
                    {   
                   	 
                        for(int index = 0; index < array.size(); index++) 
                        {
                       	 JsonObject elt =(JsonObject) array.get(index);
                       	 if (elt.isJsonObject()) {                   		 
                       	    /****Ints andStrings*****/
                       	 	int idEltArchi =elt.get("idEltArchi").getAsInt() +2000;
                       	 	
                       	 	String nomEltArchi= elt.get("nomEltArchi").getAsString();
                       	 	String appelTradi= elt.get("appelTradi").getAsString();
                       	 	String descEltArchi = elt.get("descEltArchi").getAsString();
                       	 	String typeEltArchi = elt.get("typeEltArchi").getAsString();
                       	 	
                       		/*****Arrays*****/
                       	 	JsonArray jsonImages= elt.get("images").getAsJsonArray();
                       	 	RecupImages recupImages = new RecupImages();
                       	 	recupImages.recup_images(jsonImages);
                       	 	List<Image> images = recupImages.getImages();
                       	 	for (int i =0 ; i<images.size(); i++)
                       	 	{
                       	 		int idImg = images.get(i).getIdImage()+2000;
                       	 		Image img = new Image (idImg, images.get(i).getImage(), images.get(i).getLegende());
                       	     	images.set(i, img);
                       	 	}
                       	 	
                       	 	JsonArray jsonSources= elt.get("sources").getAsJsonArray();
                       	 	RecupSources recupSources = new RecupSources();
                       	 	recupSources.recup_sources(jsonSources);
                       	 	List<Source> sources = recupSources.getSources();
                        	for (int i =0 ; i<sources.size(); i++)
                    	 	{
                    	 		int idSrc = sources.get(i).getIdSource()+2000;
                    	 		Source src = new Source(idSrc, sources.get(i).getSource(), sources.get(i).getTypeSource());
                    	 		sources.set(i, src);
                    	 	}
                        	 
                       	 	JsonArray jsonFonctions= elt.get("fonctions").getAsJsonArray();
                       	 	RecupFonctions recupFonctions = new RecupFonctions();
                       	 	recupFonctions.recup_fonctions(jsonFonctions);
                       	 	List<Fonction> fonctions = recupFonctions.getFonctions();
                        	for (int i =0 ; i<fonctions.size(); i++)
                    	 	{
                    	 		int idFct = fonctions.get(i).getIdFonction()+2000;
                    	 		Fonction fct = new Fonction(idFct, fonctions.get(i).getFonction(), fonctions.get(i).getTypeFonction());
                    	 		fonctions.set(i, fct);
                    	 	}
                       	 	      	 	
                       	 	EltArchi eltArchi= new EltArchi(idEltArchi, nomEltArchi, appelTradi, descEltArchi, typeEltArchi, fonctions, sources, images);
                       	    this.eltsArchi.add(eltArchi);
                       	 	
                       	 }
                        }
                                        	 
                    }
                    }
                    }         
                    catch(Exception e) {e.printStackTrace();}

                    conn.disconnect();
                }
             }
    

     } catch (MalformedURLException e) {
         e.printStackTrace();
     }catch (IOException e){
         e.printStackTrace();
     }finally
         {
             if(conn != null)
             { conn.disconnect();}
         }
 	}
         else
         {
        	 System.out.println("Ce type de maisons n'existe pas");
         }
 	}

}

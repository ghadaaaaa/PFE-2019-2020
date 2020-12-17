package com.turath.nlp;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.turath.model.Image;

public class RecupImages {
	
	private List<Image> images= new ArrayList<Image>();
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	public void recup_images(JsonArray jsonImages)
	{
		if (jsonImages.isJsonArray()) 
        {   
            for(int index = 0; index < jsonImages.size(); index++) 
            {
            	 JsonObject elt =(JsonObject) jsonImages.get(index);
            	 if (elt.isJsonObject()) 
            	 { 
            		 int idImage =elt.get("idImage").getAsInt();
            		 String img = elt.get("image").getAsString();
            		 String legende = elt.get("legende").getAsString();
            	     Image image = new Image(idImage, img, legende);
            	     this.images.add(image);
            	 }
	        }
        }
    }
	
}
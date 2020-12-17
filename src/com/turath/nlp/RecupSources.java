package com.turath.nlp;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.turath.model.Source;

public class RecupSources {
	
private List<Source> sources = new ArrayList<Source>();
	
	
	
	public List<Source> getSources() {
	return sources;
}



public void setSources(List<Source> sources) {
	this.sources = sources;
}



	public void recup_sources(JsonArray jsonSources)
	{
		if (jsonSources.isJsonArray()) 
        {   
            for(int index = 0; index < jsonSources.size(); index++) 
            {
            	 JsonObject elt =(JsonObject) jsonSources.get(index);
            	 if (elt.isJsonObject()) 
            	 { 
            		 int idSource =elt.get("idSource").getAsInt();
            		 String src = elt.get("source").getAsString();
            		 String typeSource = elt.get("typeSource").getAsString();
            	     Source source = new Source(idSource, src, typeSource);
            	     this.sources.add(source);
            	 }
	        }
        }
    }

}

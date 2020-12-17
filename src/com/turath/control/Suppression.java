package com.turath.control;

import org.apache.jena.query.Dataset;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import com.turath.sdb.SDBManipulation;

public class Suppression {
	
	public Suppression() {}
	
	/*******************SUPPRIMER MAISON ******************/
	public boolean supp_maison(int idMaison, Dataset dataset)
	{
		boolean deleted = false;
		String supp_maison="prefix rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
	                     +"prefix rdfs:	  <http://www.w3.org/2000/01/rdf-schema#>"
			             +"prefix mysdb:  <http://www.w3.org/ontologies/patriArchi#> "
			             +"DELETE where"
		                 +"{graph <http://www.w3.org/ontologies/patriArchi> {"
		                 +"?Maison mysdb:idEltPatri "+idMaison+"."
					     + "}"
					     +"}";

		
		try {		  
	      	 UpdateRequest update  = UpdateFactory.create(supp_maison);
			 UpdateProcessor qexec = UpdateExecutionFactory.create(update, dataset);
			 qexec.execute();
			 deleted = true;
			 System.out.println("La maison a été supprimée avec succès");
			    }
		    catch(Exception e){ 
		    	 System.out.println(e.getMessage());		
	                           }
        return deleted;
	}
}

package com.turath.control;

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import com.turath.model.MaisonGestion;
import com.turath.sdb.SDBManipulation;

public class TestModif {
	public static void main (String[] args)
	{	
		
		SDBManipulation sdb = new  SDBManipulation();
		sdb.connexionASDB();
		/*******Def maison*******/
		String source = "CNRA";
		Map<String,String> appels =new HashMap<String,String>();
	    appels.put("Médina d'Alger", source);
		Map<String,String> images = new HashMap<String,String>();
		
		float altitude =13;
		float longitude =12;
		int valide =1;
		int supprime =0;

		MaisonGestion maison = new MaisonGestion(2,"Baie d'Alger",source,altitude, longitude, source, 
				"14/05/199", "Othomane", source, "30", "60", source, appels, images, valide, supprime);
		
        /*******Récup données maison*******/
int idMaison = maison.getIdEltPatri();
String descMaison =maison.getDescEltPatri();
String sourceDesc =maison.getSourcedesc();

String altitudeMaison = Float.toString(maison.getAltitude());
String longitudeMaison = Float.toString(maison.getLongitude());
String sourceAltLong = maison.getSourcealtlong();

String dateConstructionMaison = maison.getDateConstruction();
String périodeConstructionMaison= maison.getPériodeConstruction();
String sourceDatePériode = maison.getSourceDatePériode();

String surfaceSol =maison.getSurfaceSol();
String surfaceMaison= maison.getSurfaceMaison();
String sourceSurface= maison.getSourceSurface();

int valideMaison = maison.getValide();
int supprimeMaison =maison.getSupprime();

Map<String, String> appelsMaison =maison.getAppels();
Map<String, String> imagesMaison =maison.getImages();
                        /**********Requete suppression********/
Suppression s = new Suppression();
boolean deleted = s.supp_maison(idMaison, sdb.getDataset());
if (deleted == false)
{System.out.println("Erreur");}

                        /***********Requete ajout************/
else {
String addMaison="prefix rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
         +"prefix rdfs:	  <http://www.w3.org/2000/01/rdf-schema#>"
	     +"prefix mysdb:  <http://www.w3.org/ontologies/patriArchi#> "
	     +"INSERT Data {graph <http://www.w3.org/ontologies/patriArchi> {"
	     +" mysdb:Maison"+idMaison+" mysdb:idEltPatri "+idMaison+";"
	     +"				               mysdb:descEltPatri \""+descMaison+"\";"
         +"                            rdfs:descEltPatri \""+sourceDesc+"\";"
        
         +"				               mysdb:altitude\""+altitudeMaison+"\";"
         +"				               mysdb:longitude\""+longitudeMaison+"\";"
         +"				               rdfs:altitude\""+sourceAltLong+"\";"
        +"				               rdfs:longitude\""+sourceAltLong+"\";"
        
        +"				               mysdb:dateConstruction\""+dateConstructionMaison+"\";"
        +"				               mysdb:périodeConstruction\""+périodeConstructionMaison+"\";"
        +"				               rdfs:dateConstruction\""+sourceDatePériode+"\";"
        +"				               rdfs:périodeConstruction\""+sourceDatePériode+"\";"
        
	    +"				               mysdb:surfaceSol\""+surfaceSol+"\";"
        +"				               mysdb:surfaceMaison\""+surfaceMaison+"\";"
        +"				               rdfs:surfaceSol\""+sourceSurface+"\";"
        +"				               rdfs:surfaceMaison\""+sourceSurface+"\";"
       
        +"				               mysdb:valide\""+valideMaison+"\";"
        +"				               mysdb:supprime\""+supprimeMaison+"\"."
	     +" mysdb:Maison"+idMaison+" rdf:type mysdb:Maison."
	     +" mysdb:Maison a rdfs:Class."
	     + "}}";

try {		  
	 UpdateRequest update  = UpdateFactory.create(addMaison);
UpdateProcessor qexec = UpdateExecutionFactory.create(update, sdb.getDataset());
qexec.execute();
System.out.println("Maisons modifiée avec succès");
   }
catch(Exception e){ 
	 System.out.println(e.getMessage());
	}
}


/*************Vérification**************/

try

{
String qs1 = "Select ?idEltPatri ?descEltPatri ?sourceDesc ?valide ?supprime ?altitude ?longitude ?sourceAltLong "
+ "where {graph ?g {"

//  + "?Maison <http://www.w3.org/ontologies/patriArchi#idEltPatri> "+idMaisonV+"."
+ "?Maison <http://www.w3.org/ontologies/patriArchi#idEltPatri> ?idEltPatri."

+ "?Maison <http://www.w3.org/ontologies/patriArchi#descEltPatri> ?descEltPatri."
+ "?Maison <http://www.w3.org/2000/01/rdf-schema#descEltPatri> ?sourceDesc."

+ "?Maison <http://www.w3.org/ontologies/patriArchi#altitude> ?altitude."
+ "?Maison <http://www.w3.org/ontologies/patriArchi#longitude> ?longitude."
+ "?Maison <http://www.w3.org/2000/01/rdf-schema#longitude> ?sourceAltLong."


+ "?Maison <http://www.w3.org/ontologies/patriArchi#valide> ?valide."
+ "?Maison <http://www.w3.org/ontologies/patriArchi#supprime> ?supprime."


+ "}}";

try(QueryExecution qExec = QueryExecutionFactory.create(qs1, sdb.getDataset())) {
ResultSet rs = qExec.execSelect() ;
ResultSetFormatter.out(rs) ;

}
}
finally {} 





sdb.deconnexionDeSDB();
}
	
}


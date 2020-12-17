package com.turath.control;
import java.util.HashMap;
import java.util.Map;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import com.turath.model.MaisonGestion;
import com.turath.sdb.SDBManipulation;

public class TestAjout {
	
	public static void main (String[] args)
	{		 
		/*******Def maison*******/
		String source = "CNRA";
		SDBManipulation sdb = new  SDBManipulation();
		sdb.connexionASDB();
		Map<String,String> appels =new HashMap<String,String>();
        appels.put("Dar l'Emir Abdelkader", source);
    
		Map<String,String> images = new HashMap<String,String>();
	    images.put ("img/Dar l'Emir Abdelkader.jpeg", source);
		float altitude = (float) 36.30506;
		float longitude = (float)2.23112;
		int valide =0;
		int supprime =0;
	
		MaisonGestion maison = new MaisonGestion(10,"Selon la tradition locale on affirme que cette demeure fut pendant la période Turque la Résidence du Bey de Miliana puis siège de Califat de l’Emir Abdelkader, d’où l’appellation actuelle DAR EL EMIR. Après la prise de Miliana par les français en 1840, ce bâtiment devient alors le Siège de la Subdivision Militaire commandant le Neuvième Tirailleur et commandée respectivement par le Lieutenant d’Illens et le Général Saint Arnaud. Aussi ce bâtiment accueille le 8 Mai 1865 Napoléon III lors de sa visite en Algérie.D’autre part, on affirme que l’une des cours de cet édifice devint vers le milieu de l’Année 1859, grâce à l’initiative du Général Liebert, un véritable Musée où on conservait de nombreuses Antiquités. Occupant une superficie de 2624 m², cet édifice de style Mauresque est dépourvu de tout ornement décoratif de l’époque, à savoir : Céramique, Boiserie, Plâtre. Le Patio orné d’un Jet d’eau est entouré de Galeries quadrangulaires soutenues par des Arcades. Après avoir subi des travaux de Restauration, ce bâtiment a été aménagé en Musée depuis 1997 et renferme plusieurs Salles d’Exposition (Ethnographie, Antiquités Romaines, Résistance Populaire, les Mines du Zaccar et la période de la Guerre de Libération).",
				source,altitude, longitude, source, 
				"Non renseigné", "Non renseigné", source,
				"2624 m²", "Non renseigné", source, appels, images, valide, supprime);
		Ajout a =new Ajout();
		a.add_maison_sdb(maison, sdb.getDataset());
		
		                        /*************Vérification**************/
	     int idMaisonV =1;
		
		 try
			
		 {
			  String qs1 = "Select ?idEltPatri ?descEltPatri ?sourceDesc ?valide ?supprime ?altitude ?longitude ?sourceAltLong "
			  		+ "where {graph ?g {"
			  		
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

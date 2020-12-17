package com.turath.servlets;


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import com.turath.sdb.SDBManipulation;




public class FlaskTest {
    public static void main(String args[]) {
     
	 SDBManipulation sdb = new  SDBManipulation();
	
	 sdb.chargerFichierOWLDansSDB();
	 sdb.connexionASDB();
		/*try {
			Connection conx=sdb.connexionASDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		  
	 Dataset dataset = sdb.getDataset();
	 
	 try
	 {
		 int idEltPatri=3;
	
		 /******************Liste des appellation des types de maisons****************/
	 String qs1 = "Select ?appelTypeMa where {graph ?g {"
			+ "?AppellationTypeMa <http://www.w3.org/ontologies/patriArchi#AppeleMa> ?TypeMa." 
	        + "?TypeMa <http://www.w3.org/ontologies/patriArchi#ContenirMa> ?Maison." 
	        + "?AppellationTypeMa <http://www.w3.org/ontologies/patriArchi#appelTypeMa> ?appelTypeMa."
            + "?Maison <http://www.w3.org/ontologies/patriArchi#idEltPatri> "+idEltPatri+"."
      + "}}";

		 try(QueryExecution qExec = QueryExecutionFactory.create(qs1, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		 
		 /***********Liste des Orgas qui reconnaissent un elt patri**********/
		 int id= 2;
		 String qs2 = "Select ?acroOrga ?nomOrga where {graph ?g {"
					+ "?Organisation <http://www.w3.org/ontologies/patriArchi#acroOrga> ?acroOrga." 
			        + "?Organisation <http://www.w3.org/ontologies/patriArchi#nomOrga> ?nomOrga." 
			        + "?Organisation <http://www.w3.org/ontologies/patriArchi#ReconnaitreEP> ?EltPatri." 
			        + "?EltPatri <http://www.w3.org/ontologies/patriArchi#idEltPatri> "+id+"."
			        
		      + "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs2, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}

	 /**************liste des elts architecturaux d'un elt patri*************/
		 int idElt= 3;
		 String qs3 = "Select ?idEltArchi ?nomEltArchi ?appelTradi where {graph ?g {"
			
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#idEltArchi> ?idEltArchi." 
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#appelTradi> ?appelTradi."
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#nomEltArchi> ?nomEltArchi."
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#ContenuDansEP> ?EltPatri."
					+ "?EltPatri <http://www.w3.org/ontologies/patriArchi#idEltPatri> "+idElt+"."
			        
		      + "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs3, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		 
		                   /****************Le type d'un elt archi******************/
		 int idEltArchi=1;
		 String qs4 = "Select ?typeEA where {graph ?g {"				
					+ "?TypeEA <http://www.w3.org/ontologies/patriArchi#typeEA> ?typeEA." 
					+ "?TypeEA <http://www.w3.org/ontologies/patriArchi#ContenirEltA> ?EltArchi."
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#idEltArchi> "+idEltArchi+"."       
		      + "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs4, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		 
		                  /****************Les fonctions d'un elt archi*************/
		 int idEltA=1;
		 String qs5 = "Select ?fonction where {graph ?g {"	
				 
					+ "?FonctionEltArchi <http://www.w3.org/ontologies/patriArchi#fonction> ?fonction." 
					+ "?FonctionEltArchi <http://www.w3.org/ontologies/patriArchi#AssureeParEA> ?EltArchi."
					+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#idEltArchi> "+idEltA+"."
		      + "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs5, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		 					/*****Les types de Confort******/
  String qs8 = "Select ?idTypeConfort ?typeConfort where {graph ?g {"	
					 
					+ "?TypeConfort <http://www.w3.org/ontologies/patriArchi#idTypeConfort> ?idTypeConfort." 
					+ "?TypeConfort <http://www.w3.org/ontologies/patriArchi#typeConfort> ?typeConfort." 
					+ "}}";	 
  try(QueryExecution qExec = QueryExecutionFactory.create(qs8, dataset)) {
	   ResultSet rs = qExec.execSelect() ;
	   ResultSetFormatter.out(rs) ;
	   
  } 
  catch(Exception e) { e.printStackTrace();}
		 
		                  /****************Les aspects env d'un Type Maison*************/
    int idTypeMa=1;
   String qs7 = "Select ?idAspectEnv ?aspectEnv ?descAspectEnv where {graph ?g {"	
				 
					+ "?AspectEnv <http://www.w3.org/ontologies/patriArchi#idAspectEnv> ?idAspectEnv." 
					+ "?AspectEnv <http://www.w3.org/ontologies/patriArchi#aspectEnv> ?aspectEnv." 
					+ "?AspectEnv <http://www.w3.org/ontologies/patriArchi#descAspectEnv> ?descAspectEnv." 
					+ "?AspectEnv <http://www.w3.org/ontologies/patriArchi#RelatifAAE> ?TypeMa." 
					+ "?TypeMa <http://www.w3.org/ontologies/patriArchi#idTypeMa> "+idTypeMa+"." 
					+ "}}";

   try(QueryExecution qExec = QueryExecutionFactory.create(qs7, dataset)) {
	   ResultSet rs = qExec.execSelect() ;
	   ResultSetFormatter.out(rs) ;
	   
   } 
   catch(Exception e) { e.printStackTrace();}
	                           /**********Le type confort d'un aspect env***********/
   int idAspectEnv=1;
   String qs9 = "Select ?typeConfort where {graph ?g {"	
					+ "?TypeConfort <http://www.w3.org/ontologies/patriArchi#typeConfort> ?typeConfort."
					+ "?TypeConfort <http://www.w3.org/ontologies/patriArchi#ContenirAE> ?AspectEnv." 
					+ "?AspectEnv <http://www.w3.org/ontologies/patriArchi#idAspectEnv> "+idAspectEnv+"."  
					+ "}}";

   try(QueryExecution qExec = QueryExecutionFactory.create(qs9, dataset)) {
	   ResultSet rs = qExec.execSelect() ;
	   ResultSetFormatter.out(rs) ;
	   
   } 
   catch(Exception e) { e.printStackTrace();}
		 			    	/*******************Les sources******************/
    String qs6 = "Select ?idSource ?source ?typeSource where {graph ?g {"	
				 
					+ "?Source <http://www.w3.org/ontologies/patriArchi#idSource> ?idSource." 
					+ "?Source <http://www.w3.org/ontologies/patriArchi#source> ?source." 
					+ "?Source <http://www.w3.org/ontologies/patriArchi#typeSource> ?typeSource." 
					+ "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs6, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		 
		 					/******************Les personnes******************/
		 					/********Fondateur d'un Elt patri*******/
int idEltFonde=3;
String qs10 = "Select ?idPersonne ?nomCompletPersonne ?profession  ?dateFondation where {graph ?g {"	
				 
					+ "?Fondateur <http://www.w3.org/ontologies/patriArchi#idPersonne> ?idPersonne." 
					+ "?Fondateur <http://www.w3.org/ontologies/patriArchi#nomCompletPersonne> ?nomCompletPersonne."
					+ "?Fondateur <http://www.w3.org/ontologies/patriArchi#profession> ?profession."
					+ "?Fondateur <http://www.w3.org/ontologies/patriArchi#FonderEP> ?EltPatri."
					+ "?EltPatri <http://www.w3.org/ontologies/patriArchi#idEltPatri>"+idEltFonde+"." 
					+ "?EltPatri <http://www.w3.org/ontologies/patriArchi#AvoirFondationEP> ?Fondation."
					+ "?Fondation <http://www.w3.org/ontologies/patriArchi#dateFondation> ?dateFondation."
					+ "}}";
		 try(QueryExecution qExec = QueryExecutionFactory.create(qs10, dataset)) {
			   ResultSet rs = qExec.execSelect() ;
			   ResultSetFormatter.out(rs) ;
			   
		 } 
		catch(Exception e) { e.printStackTrace();}
		                    /********Constructeur d'un Elt patri*******/
		 int idEltConstruit=3;
		 String qs11 = "Select ?idPersonne ?nomCompletPersonne ?dateConstruction where {graph ?g {"	
		 				 
		 					+ "?Constructeur <http://www.w3.org/ontologies/patriArchi#idPersonne> ?idPersonne." 
		 					+ "?Constructeur <http://www.w3.org/ontologies/patriArchi#nomCompletPersonne> ?nomCompletPersonne."
		 					+ "?Constructeur <http://www.w3.org/ontologies/patriArchi#Construire> ?EltPatri."
		 					+ "?EltPatri <http://www.w3.org/ontologies/patriArchi#idEltPatri>"+idEltConstruit+"." 
		 					+ "?EltPatri <http://www.w3.org/ontologies/patriArchi#AvoirConstructionEP> ?Construction."
				        	+ "?Construction <http://www.w3.org/ontologies/patriArchi#dateConstruction> ?dateConstruction."
					        + "}}";
		 			
		 		 try(QueryExecution qExec = QueryExecutionFactory.create(qs11, dataset)) {
		 			   ResultSet rs = qExec.execSelect() ;
		 			   ResultSetFormatter.out(rs) ;
		 			   
		 		 } 
		 		catch(Exception e) { e.printStackTrace();}
		 		             /********Réstaurateur d'un Elt patri*******/
		 		 
		                     /********Propriétaires d'un EltParti*******/
		 		 
		 		 
		 
     sdb.deconnexionDeSDB();
      
    
    } catch(Exception e) {}}}
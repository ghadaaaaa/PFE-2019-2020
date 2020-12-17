package com.turath.nlp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import com.turath.control.Ajout;
import com.turath.model.EltArchi;
import com.turath.sdb.SDBManipulation;

public class testRecupFichesInSDB {
	public static void main (String[] args)
	{
		
		SDBManipulation sdb = new  SDBManipulation();
	    //sdb.chargerFichierOWLDansSDB();
	   sdb.connexionASDB();
		
	/*	try {
			Connection conx=sdb.connexionASDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		  Ajout a = new Ajout();
		
		
		/***********Ajout des elts archi des maisons à chbek*************/
		RecupEltsArchi recup= new RecupEltsArchi();
		recup.recup_elts_archi("maison à CHBEK");
		List<EltArchi> eltsChbek= recup.getEltsArchi();
		
		boolean added =true;
		int i=0;
		while ((added == true) &&  (i<eltsChbek.size()))
		{
		added = a.add_elt_archi_sdb(eltsChbek.get(i), sdb.getDataset());
		i ++;
		}
		
		
		/***********Ajout des elts archi des maisons Alawi*************/
		recup.recup_elts_archi("maison Alawi");
		List<EltArchi> eltsAlawi= recup.getEltsArchi();
		i=0;
		while ((added == true) &&  (i<eltsAlawi.size()))
		{
		added = a.add_elt_archi_sdb(eltsAlawi.get(i), sdb.getDataset());
		i ++;
		}
		
		
		/***********Ajout des elts archi des maisons à west dar*************/
		recup.recup_elts_archi("maison à west dar");
		List<EltArchi> eltsWestDar= recup.getEltsArchi();
		i=0;
		while ((added == true) &&  (i<eltsWestDar.size()))
		{
		added = a.add_elt_archi_sdb(eltsWestDar.get(i), sdb.getDataset());
		i ++;
		}
		/******************************************************************/
		
		
		/********************Liste des fonctions***********************/
	String selectFct = "Select ?idFonction ?fonction ?typeAspect where {graph ?g {"
				+ "?FonctionEltArchi <http://www.w3.org/ontologies/patriArchi#idFonction> ?idFonction." 
				+ "?FonctionEltArchi <http://www.w3.org/ontologies/patriArchi#fonction> ?fonction."
				+ "?FonctionEltArchi <http://www.w3.org/ontologies/patriArchi#typeAspect> ?typeAspect."

		        
	      + "}}";
	 try(QueryExecution qExec = QueryExecutionFactory.create(selectFct, sdb.getDataset())) {
		   ResultSet rs = qExec.execSelect() ;
		   ResultSetFormatter.out(rs) ;
		   
	 } 
	catch(Exception e) { e.printStackTrace();}
	 
	 		/********************Liste des images***********************/
	 String selectImg = "Select ?idIllustration ?illustration ?legende where {graph ?g {"
				+ "?Illustration <http://www.w3.org/ontologies/patriArchi#idIllustration> ?idIllustration." 
				+ "?Illustration <http://www.w3.org/ontologies/patriArchi#illustration> ?illustration."
				+ "?Illustration <http://www.w3.org/ontologies/patriArchi#legende> ?legende."	        
	      + "}}";
	 try(QueryExecution qExec = QueryExecutionFactory.create(selectImg, sdb.getDataset())) {
		   ResultSet rs = qExec.execSelect() ;
		   ResultSetFormatter.out(rs) ;
		   
	 } 
	catch(Exception e) { e.printStackTrace();}
	  
	 /********************Liste des sources***********************/
	 String selectSrc= "Select ?idSource ?source ?typeSource where {graph ?g {"
				+ "?Source <http://www.w3.org/ontologies/patriArchi#idSource> ?idSource." 
				+ "?Source <http://www.w3.org/ontologies/patriArchi#source> ?source."
				+ "?Source <http://www.w3.org/ontologies/patriArchi#typeSource> ?typeSource."
	      + "}}";
	 try(QueryExecution qExec = QueryExecutionFactory.create(selectSrc, sdb.getDataset())) {
		   ResultSet rs = qExec.execSelect() ;
		   ResultSetFormatter.out(rs) ;
		   
	 } 
	catch(Exception e) { e.printStackTrace();}
	 
	 
		String selectEltArchi = "Select ?idEltArchi ?nomEltArchi ?appelTradi ?typeEltArchi ?descEltArchi where {graph ?g {"			
				+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#idEltArchi> ?idEltArchi." 
				+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#nomEltArchi> ?nomEltArchi."
				+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#appelTradi> ?appelTradi."
				+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#typeEltArchi> ?typeEltArchi."
				+ "?EltArchi <http://www.w3.org/ontologies/patriArchi#descEltArchi> ?descEltArchi."
	      + "}}";
	 try(QueryExecution qExec = QueryExecutionFactory.create(selectEltArchi, sdb.getDataset())) {
		   ResultSet rs = qExec.execSelect() ;
		   ResultSetFormatter.out(rs) ;
		   
	 } 
	catch(Exception e) { e.printStackTrace();}
	sdb.deconnexionDeSDB();

		
		
		sdb.deconnexionDeSDB();
		
	}

}

package com.turath.SDBActorsDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.turath.SDBActorsBean.Admin;
import com.turath.SDBActorsBean.Architecte;
import com.turath.sdb.SDBManipulation;

public class Test {
 
	public static void main(String[] args) throws SQLException { 
	// TODO Auto-generated constructor stub
		SDBArchitectConnection SDBActConn = new SDBArchitectConnection();
		Connection conx= SDBActConn.connect();
		System.out.println("after connexion");
		//Architecte actor = new Architecte (1,"ghada@esi.dz","12345","flissi","ghada","epau", false, "piece_identity", "diplome");
		//SDBActConn.insertArchitecte(actor);
		//Architecte actor2 = new Architecte (2,"ghadaaaa@esi.dz","12345","flissi","ghada","esi", false,  "piece_identity", "diplome");
	//	SDBActConn.insertArchitecte(actor2);
		/***************Admin***********************/
		List<Architecte> listArchi=new ArrayList<Architecte>();
		SDBAdminConnection SDBAdminConn = new SDBAdminConnection ();
		Connection con= SDBAdminConn.connect();
		System.out.println("connected");
		/*Admin admin = new Admin(1,"chahinez@esi.dz","12345","slatnia","chahinez");
		SDBAdminConn.insertAdmin(admin);
		System.out.println(
				String.format("%s, %s actor had inserted with ", admin.getMail(), admin.getPassword()
				)); 
		System.out.println("test "+ admin.getPrenom());*/
		System.out.println("let's see");
		System.out.println(SDBAdminConn.AfficherArchitectesNonValides());
} 
	

	
	
}

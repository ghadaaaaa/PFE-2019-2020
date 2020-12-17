package com.turath.SDBActorsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.turath.SDBActorsBean.Architecte;
import com.turath.sdb.SDBManipulation;

public class SDBArchitectConnection {

	private final String url = "jdbc:postgresql://localhost:5432/NewSDB";
    private final String user = "Turath";
    private final String password = "Turath";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
   
    public boolean validate(Architecte login) throws ClassNotFoundException {
        boolean status = false;
        String SQL= "select * from public.\"architecte_table\" where email = ? and password = ? ";
        try (	
           
        	Connection conx = connect();
            PreparedStatement preparedStatement = conx
            .prepareStatement(SQL)) {
            preparedStatement.setString(1, login.getMail());
            preparedStatement.setString(2, login.getPassword());
       
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            login.setNom(rs.getString(4));
            login.setPrenom(rs.getString(5));
            login.setEtablissement(rs.getString(6));
            login.setValide(rs.getBoolean(7));
            login.setPiece_identity(rs.getBytes(8));
            login.setDiplome(rs.getBytes(9));


        } catch (SQLException e) {
            // process sql exception
        	System.out.println(e.getMessage());
        }
        return status;
    }

    public void insertArchitecte(Architecte actor) throws SQLException {
    	//SDBManipulation conn= new SDBManipulation();
    	Connection conn = connect();
    	System.out.println("connecté inside insert actor");
    	try {
    		//conn.connexionASDB();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        String SQL = "INSERT INTO public.\"architecte_table\"(\r\n" + 
        		"	id, email, password, nom, prenom, etablissement, valide, piece_identity, diplome)\r\n" + 
        		"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    

        try (
        		
        		
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
        	pstmt.setInt(1, actor.getId());
            pstmt.setString(2, actor.getMail());
            pstmt.setString(3, actor.getPassword());
            pstmt.setString(4, actor.getNom());
            pstmt.setString(5, actor.getPrenom());
            pstmt.setString(6, actor.getEtablissement());
            pstmt.setBoolean(7, actor.isValide());
            pstmt.setBytes(8, actor.getPiece_identity());
            pstmt.setBytes(9, actor.getDiplome());
            pstmt.execute();
            System.out.println("done");
          //  int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            /*if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }*/
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    
    public boolean VerifExistEmail(Architecte acteur, String email) throws ClassNotFoundException {
        boolean status = false;
        String SQL= "select * from public.\"architecte_table\" where email = ? ";
        try (	
           
        	Connection conx = connect();
            PreparedStatement preparedStatement = conx
            .prepareStatement(SQL)) {
            preparedStatement.setString(1, acteur.getMail());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
        	System.out.println(e.getMessage());
        }
        return status;
    }
    
    public int GeneratorId(Architecte acteur )throws ClassNotFoundException {
    	int count =0;
    	String SQL = "SELECT * from public.\"architecte_table\" ";
    	try(
    		
    		Connection conx = connect();
            PreparedStatement preparedStatement = conx
            .prepareStatement(SQL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {count++;}

        } catch (SQLException e) {
            // process sql exception
        	System.out.println(e.getMessage());
        }

    return count+1;
    }
    /*******************************************************************/
    /******** binary file piece d'identite*********/
    public byte[] PieceFile(int id) {
    	String SQL = "SELECT * from public.\"architecte_table\" where id = ?";
    	byte[] piece_identity=null;
    	try (
    		
    		Connection conx = connect();
    		
            PreparedStatement preparedStatement = conx
            .prepareStatement(SQL)) {
    		preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	piece_identity = rs.getBytes(8);
                       }
           
            
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    	if(piece_identity == null) return null;
  		else return piece_identity;
    	

    
   }
    
    /******** binary file diplome*********/
    public byte[] DiplomeFile(int id) {
    	String SQL = "SELECT * from public.\"architecte_table\" where id = ?";
    	byte[] diplome=null;
    	try (
    		
    		Connection conx = connect();
    		
            PreparedStatement preparedStatement = conx
            .prepareStatement(SQL)) {
    		preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	diplome = rs.getBytes(9);
                       }
           
            
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    	if(diplome == null) return null;
  		else return diplome;
    	

    }
    
}
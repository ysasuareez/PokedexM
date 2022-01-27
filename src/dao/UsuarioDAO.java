package dao;

//CTRL + SHIFT + O -> imports automaticos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO {

    final String DB_URL = "jdbc:mysql://localhost/PokedexM";
    final String USER = "ysasuareez";
    final String PASS = "ysasuarez18Y.";
    final String QUERY = "SELECT username, password FROM usuarios";
    
    public void consulta() {
    	 try{    		 
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
    	      		      
	         while(rs.next()){
	            //Display values
	            System.out.print("Username: " + rs.getString("username"));
	            System.out.print("Password: " + rs.getString("password"));  
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
    }
    
    public boolean login(Usuario usuario) {
    	final String QUERY = "SELECT username, password FROM usuarios "
    			+ "where username = '" + usuario.getUsername() + "' and " 
    			     + "password = '" + usuario.getPassword() + "'" ;
    	   
		try{			 
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(QUERY);
		  		      
		    return rs.next();
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
			   	
			return false;
    }
    
//    insert into usuarios (username, password) 
//    values ('ysi', 'ysi');
    
    //Es muy parecido al login, solo que no es void ya que su funcion solo es introducir y no devolver
    public void registrar(Usuario usuario) {
    	final String INSERT = "insert into usuarios (username, password) values ('"
    			 + usuario.getUsername() + "', '" + usuario.getPassword() + "');" ;	   
    	
		try{			 
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(INSERT);
		 
		} catch (SQLException e) {
		    e.printStackTrace();
		}
			   	
    }
    
    
}

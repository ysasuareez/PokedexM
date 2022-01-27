package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.TiposPokemon;
import models.Pokemon;
import models.Usuario;

public class PokemonDAO {

    final String DB_URL = "jdbc:mysql://localhost/PokedexM";
    final String USER = "ysasuareez";
    final String PASS = "ysasuarez18Y.";
    
    
    public Pokemon primero() {
    	
    	final String QUERY = "SELECT idPokemon, nombre, tipo1, tipo2, altura, peso, categoria, "
        		+ "habilidad, imagen FROM usuarios limit 1";
    	
    	 try{    		 
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
    	      		      
	         while(rs.next()){
	            //Display values
	            int idPokemon = rs.getInt("idPokemon");
	            String nombre = rs.getString("nombre"); 	            
	            TiposPokemon tipo1 = TiposPokemon.valueOf(rs.getString("tipo1")); 
	            TiposPokemon tipo2 = TiposPokemon.valueOf(rs.getString("tipo2")); 
	            double altura = rs.getDouble("altura");  
	            double peso = rs.getDouble("peso");  
	            String categoria = rs.getString("categoria");  
	            String habilidad = rs.getString("habilidad");  
	            String imagen = rs.getString("imagen"); 
	            Pokemon pokemon = new Pokemon(idPokemon, nombre, tipo1, tipo2, altura, peso, categoria, habilidad, imagen);
	            return pokemon;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return null;
    }
    
    
    public ArrayList <Pokemon> getAll() {
    	
    	final String QUERY = "SELECT idPokemon, nombre, tipo1, tipo2, altura, peso, categoria, habilidad, imagen FROM pokemons";
    	
    	ArrayList <Pokemon> lista_pokemons = new ArrayList <Pokemon> ();
    	
    	 try{    		 
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
    	      		      
	         while(rs.next()){
	            //Display values
	            int idPokemon = rs.getInt("idPokemon");
	            String nombre = rs.getString("nombre"); 
	            TiposPokemon tipo1 = TiposPokemon.valueOf(rs.getString("tipo1"));
	            TiposPokemon tipo2 = TiposPokemon.valueOf(rs.getString("tipo2"));
	            double altura = rs.getDouble("altura");  
	            double peso = rs.getDouble("peso");  
	            String categoria = rs.getString("categoria");  
	            String habilidad = rs.getString("habilidad");  
	            String imagen = rs.getString("imagen"); 
	            Pokemon pokemon = new Pokemon(idPokemon, nombre, tipo1, tipo2, altura, peso, categoria, habilidad, imagen);
	            lista_pokemons.add(pokemon);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return lista_pokemons;
    }

	public void insert(Pokemon pokemon) {
		
		final String INSERT = "INSERT INTO pokemons (nombre, tipo1, tipo2, altura, peso, categoria, habilidad, imagen) "		
				+ " VALUES ('" + pokemon.getNombre() + "', '" + pokemon.getTipo1() + "', '" + pokemon.getTipo2() + "', '" 
				+ pokemon.getAltura()+ "', '" + pokemon.getPeso()+ "', '" + pokemon.getCategoria() + "', '" 
				+  pokemon.getHabilidad() + "', '" + pokemon.getImagen() + "');" ;
		
		try {
			
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void actualizar(Pokemon pokemon) {
		
		final String UPDATE = "UPDATE pokemons\r\n"		
				+ "SET\r\n" 
				+ "tipo1 = '" +  pokemon.getTipo1() + "',\r\n"
				+ "tipo2 = '" + pokemon.getTipo2() + "',\r\n "
				+ "altura = '" + pokemon.getAltura()+ "',\r\n "
				+ "peso = '" + pokemon.getPeso() + "',\r\n "
				+ "categoria = '" + pokemon.getCategoria() + "',\r\n "
				+ "habilidad = '" +  pokemon.getHabilidad() + "'\r\n"
				+ "WHERE idPokemon = '" + pokemon.getIdPokemon() + "';";
		
		try {
			
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    
}

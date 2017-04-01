package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.model.Esame;

public class EsameDAO {
	
	public Esame find (String codice){
		
		String sql = "SELECT codice, titolo, docente, superato, voto, data_superamento "+
					"FROM esame "+
					"WHERE codice= ?";
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		
		Esame result = null;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, codice);
			
			ResultSet res = statement.executeQuery(sql);
			
			if(res.next()){
				Esame ex = new Esame (res.getString("codice"), res.getString("titolo"), res.getString("docente"));
				result = ex;
			}
			else
				return null;
			
			connection.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean create (Esame e){
		
		String sql = "INSERT INTO 'libretto', 'esame' ('codice', 'titolo', 'docente')";
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, e.getCodice());
			statement.setString(2, e.getTitolo());
			statement.setString(3, e.getDocente());
			
			int result = statement.executeUpdate();
			
			connection.close();
			
			if (result==1){
				return true;
			}
			else
				return false;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
		
	}

}

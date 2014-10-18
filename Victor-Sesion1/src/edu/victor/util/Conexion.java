package edu.victor.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Connection Conectarse(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sesion5","root","victor");
		} catch (Exception e) {
			System.out.println("Error de Conexión" + e.getMessage());
		}
				
		return cn;
	}

}

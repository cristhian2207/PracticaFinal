package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;

public class Conexiones {
	
	public static Connection getConnection() {
		
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop", "root", "root");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de conexión" + e.getMessage());
		}
		return conexion;
	}		
}
	

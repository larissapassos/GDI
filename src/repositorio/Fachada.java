package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Fachada {
	private String user;
	private String password;
	private String url_driver;
	public Connection con;
	
	public Fachada(String user, String password, String url_driver){
		this.user = user;
		this.password = password;
		this.url_driver = url_driver;
	}
	
	public void conectar() throws ClassNotFoundException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url_driver, user, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}

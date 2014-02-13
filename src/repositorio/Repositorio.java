package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Repositorio {
	private String user;
	private String password;
	private String url_driver;
	Connection con;
	
	public Repositorio(String user, String password, String url_driver){
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
	
	public abstract void inserir(Object objeto);
	public abstract ArrayList<Object> consultar(String consulta) throws SQLException;
}

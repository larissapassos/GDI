package repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Repositorio {
	Connection con;
	
	public Repositorio(Connection con){
		this.con = con;
	}
	
	public abstract void inserir(Object objeto);
	public abstract ArrayList<Object> consultar(String consulta) throws SQLException;
}

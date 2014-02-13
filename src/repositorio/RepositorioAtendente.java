package repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositorioAtendente extends Repositorio{

	public RepositorioAtendente(String user, String password, String url_driver) {
		super(user, password, url_driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> consultar(String consulta) throws SQLException {
		/*
		 * ss = “SELECT * FROM USUARIO WHERE CODIGO

= ?”;

pstmt = con.prepareStatement(ss);

pstmt.setInt(1,1);

pstmt.executeQuery();
		 */
		ArrayList<Object> nomes = new ArrayList<Object>();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setFetchSize(25);
		//stmt.setString(1, consulta);
		ResultSet rset = stmt.executeQuery("SELECT a.nome, T.ddd, T.numero FROM tb_atendente a, TABLE(a.telefones) T");
		while(rset.next()){
			String nome = rset.getString("nome");
			String ddd = rset.getString("ddd");
			String numero = rset.getString("numero");
			String total = nome + " " + ddd + " " + numero;
			System.out.println(total);
			nomes.add(total);
		}
		rset.close();
		stmt.close();
		return nomes;
	}

}

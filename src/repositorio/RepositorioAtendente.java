package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleResultSet;
import oracle.sql.ARRAY;

public class RepositorioAtendente extends Repositorio{

	public RepositorioAtendente(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> consultar(String consulta) throws SQLException {
		ArrayList<Object> atendentes = new ArrayList<Object>();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setFetchSize(25);
		ResultSet rset = stmt.executeQuery(consulta);
		while(rset.next()){
			String nome = rset.getString("nome");
			Date data_nascimento = rset.getDate("data_nascimento");
			String dataNascimento = data_nascimento.toString();
			String sexo = rset.getString("sexo");
			String cpf = rset.getString("cpf");
			ARRAY telArray = ((OracleResultSet) rset).getARRAY("telefones");
			for(int i = 0; i < telArray.length(); i++){
				
			}
			int guiche = rset.getInt("guiche");
		}
		rset.close();
		stmt.close();
		return atendentes;
	}

	@Override
	public boolean remover(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(String update) {
		// TODO Auto-generated method stub
		
	}

}

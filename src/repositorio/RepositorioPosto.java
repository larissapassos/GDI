package repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Posto;

public class RepositorioPosto extends Repositorio {

	public RepositorioPosto(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> consultar(String consulta) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(Object objeto, String atributo, String novoValor) {
		// TODO Auto-generated method stub
		
	}

}

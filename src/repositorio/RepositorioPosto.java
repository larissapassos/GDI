package repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
		try{
			Posto posto = (Posto)objeto;
			PreparedStatement inserirPosto = con.prepareStatement("INSERT INTO tb_posto('?', '?', (SELECT REF(e) FROM tb_endereco e WHERE e.cep = '?'), ?)");
			
			inserirPosto.setString(1, posto.codigo);
			inserirPosto.setString(2, posto.nome);
			inserirPosto.setString(3, posto.endereco.cep);
			
			File blob = new File(posto.imagePath);
			
			FileInputStream in = new FileInputStream(blob);
			
			inserirPosto.setBinaryStream(4, in,(int)blob.length());
			inserirPosto.execute();
		
		}catch (SQLException exex) { 
			exex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Object> consultar(String consulta) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(Object objeto) {
		// TODO Auto-generated method stub
		boolean removeu = false;
		String codigo = ((Posto)objeto).codigo;
		String delete = " DELETE FROM tb_posto WHERE codigo=" + codigo;
		Statement stmt;
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(delete);
			System.out.println(" Delecao realizada ");
			removeu = true;
			stmt.close();
		} catch(SQLException ex2){
			ex2.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return removeu;
	}

	@Override
	public void atualizar(Object objeto, String atributo, String novoValor) {
		// TODO Auto-generated method stub
		
	}

}

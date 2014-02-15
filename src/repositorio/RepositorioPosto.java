package repositorio;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Endereco;
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
			System.out.println("opa2");
			Posto posto = (Posto)objeto;
			
			PreparedStatement inserirPosto = con.prepareStatement("INSERT INTO tb_posto VALUES(?,?, (SELECT REF(e) FROM tb_endereco e WHERE e.cep = ?), ?)");
			
			inserirPosto.setString(1, posto.codigo);
			inserirPosto.setString(2, posto.nome);
			inserirPosto.setString(3, posto.endereco.cep);
			
			File blob = new File(posto.imagePath);
			
			FileInputStream in = new FileInputStream(blob);
			
			inserirPosto.setBinaryStream(4, in,(int)blob.length());
			inserirPosto.executeUpdate();
		
		}catch (SQLException exex) { 
			exex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Object> consultar(String consulta) throws SQLException {
		ArrayList<Object> retorno = new ArrayList<Object>();
		System.out.println("Chamou o metodo");
		Statement stmt = con.createStatement();
		System.out.println(consulta);
		ResultSet rset = stmt.executeQuery(consulta);
		System.out.println("Consulta realizada");
		while(rset.next()){
			System.out.println("entrou");
			String codigo = rset.getString("codigo");
			String nome = rset.getString("nome");
			System.out.println("Posto " + nome);
			String logradouro = rset.getString("logradouro");
			String numero = rset.getString("numero");
			String complemento = rset.getString("complemento");
			String bairro = rset.getString("bairro");
			String cidade = rset.getString("cidade");
			String estado = rset.getString("estado");
			String cep = rset.getString("cep");
			Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
			Blob emblemaBlob = rset.getBlob("emblema");
			byte teste[ ] = emblemaBlob.getBytes(1,(int)emblemaBlob.length());
			Image emblema = null;
			if (teste != null) {
				emblema = (Image)Toolkit.getDefaultToolkit().createImage(teste);
				System.out.println("Imagem gerada com sucesso");
			}
			Posto posto = new Posto(codigo, nome, endereco, emblema);
			retorno.add(posto);
			System.out.println("Posto " + posto.nome + "adicionado com sucesso ao retorno");
		}
		return retorno;
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
		
		//Caso não seja uma imagem
		if(!atributo.equalsIgnoreCase("emblema")){
			String codigo = ((Posto)objeto).codigo;
			String update = "UPDATE tb_posto SET "+atributo+ " = " +novoValor + "WHERE codigo = " + codigo; 
			Statement stmt;
			try{
				stmt = con.createStatement();
				stmt.executeUpdate(update);
				System.out.println(" Update realizado ");
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
		}
		
	}

}

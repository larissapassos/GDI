package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objetos.Endereco;
import objetos.Posto;

public class Fachada {
	private String user;
	private String password;
	private String url_driver;
	public Connection con;
	public RepositorioPosto rep;
	
	public Fachada(String user, String password, String url_driver){
		this.user = user;
		this.password = password;
		this.url_driver = url_driver;
	}
	
	public void conectar() throws ClassNotFoundException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url_driver, user, password);
			System.out.println("Conectado a database com sucesso!");
			this.rep = new RepositorioPosto(con);
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
	
	public ArrayList<Object> consulta(String codigo, String nome, String logradouro, String numero,String complemento, String bairro, String cidade, String estado, String cep) throws SQLException{
		String consulta = "SELECT * FROM tb_posto p";
		if (!codigo.isEmpty()||!nome.isEmpty()||!logradouro.isEmpty()||!numero.isEmpty()||!complemento.isEmpty()||!bairro.isEmpty()||!cidade.isEmpty()||!estado.isEmpty()||cep.isEmpty()){
			consulta += " WHERE ";
		}
		boolean and = false;
		if(!codigo.isEmpty()){
			if(!and){
				consulta = consulta + "p.codigo = \""+codigo + "\" ";
				and = true;
			}		
		}
		if(!nome.isEmpty()){
			if(!and){
				consulta = consulta + "p.nome = \""+nome+ "\" ";
				and = true;
			}else consulta = consulta + "AND p.nome = \""+nome+ "\" ";
		}
		if(!logradouro.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.logradouro = \""+logradouro+ "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.logradouro = \""+logradouro+ "\" ";
		}
		if(!numero.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.numero = \""+numero+ "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.numero = \""+numero+ "\" ";
		}
		if(!complemento.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.complemento = \""+complemento + "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.complemento = \""+complemento + "\" ";
		}
		if(!bairro.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.bairro = \""+bairro+ "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.bairro = \""+bairro+ "\" ";
		}
		if(!cidade.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.cidade = \""+cidade + "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.cidade = \""+cidade + "\" ";
		}
		if(!estado.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.estado = \""+estado + "\" ";
				and = true;
			}else consulta = consulta + "AND p.endereco.estado = \""+estado + "\" ";
		}
		if(!cep.isEmpty()){
			if(!and){
				consulta = consulta + "p.endereco.numero = "+numero + " ";
				and = true;
			}else consulta = consulta + "AND p.endereco.numero = \""+numero + "\" ";
		}
		System.out.println(consulta);
		return rep.consultar(consulta);
	}
	
	public void inserir(Posto posto){
		rep.inserir(posto);
	}
	
	public boolean remover(Posto posto) {	
		return rep.remover(posto);
	}
	
	public void atualizar(Posto posto, String atributo, String novoValor) {
		rep.atualizar(posto, atributo, novoValor);
	}
}

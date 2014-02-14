package testes;

import java.sql.SQLException;

import objetos.Endereco;
import objetos.Posto;
import repositorio.Fachada;

public class TesteInserir {
	
	public static void main(String[] args) {
		String codigo = "'005'"; 
		String nome = "'posto recife'";
		Endereco endereco = new Endereco("'bla'", "'111'", "'11'", "'1'", "'re'", "'PE'", "'40720070'");
		String imagePath = "C:\\Users\\Toshiba\\Desktop\\Dropbox_Files\\Dropbox\\Projetos Divos\\GDI\\Emblemas Postos\\Pernambuco.jpg";
		Posto posto = new Posto(codigo, nome, endereco, imagePath);
		Fachada fachada = new Fachada("system", "123", "jdbc:oracle:thin:@localhost:1521:" + "XE");
		try {
			fachada.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fachada.inserir(posto);
		fachada.desconectar();
	}
}
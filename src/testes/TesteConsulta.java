package testes;

import java.sql.SQLException;
import java.util.ArrayList;

import repositorio.Fachada;

public class TesteConsulta {
	public static String nome_bd = "XE";
	public static String senha_sqlplus = "farofa";
	public static String logradouro = "";
	public static String numero = "";
	public static String complemento = "";
	public static String bairro = "";
	public static String cidade = "";
	public static String estado = "";
	public static String cep = "";
	public static String codigo = "";
	public static String nome = "";
	public static void main(String[] args) {
		Fachada fachada = new Fachada("system", senha_sqlplus, "jdbc:oracle:thin:@localhost:1521:" + nome_bd);
		try {
			fachada.conectar();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			ArrayList<Object> retorno = fachada.consulta(codigo,  nome,  logradouro,  numero, complemento,  bairro,  cidade,  estado,  cep);
			System.out.println(retorno.size());
			fachada.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fachada.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

package testes;

//import java.util.Scanner;

import repositorio.Fachada;

public class TesteRepo {
	public static String nome_bd = "ORCL";
	public static String senha_sqlplus = "farofa";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean conectou = false;
		//Scanner in = new Scanner(System.in);
		Fachada fachada = new Fachada("system", senha_sqlplus, "jdbc:oracle:thin:@localhost:1521:" + nome_bd);
		System.out.println("Vamos tentar conectar!");
		try {
			fachada.conectar();
			conectou = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conectou) {
			System.out.println("Conectado ao Oracle com sucesso!");
			System.out.println("Digite a consulta: ");
			//String consulta = in.nextLine();
			//fachada.consultar(consulta);
			fachada.desconectar();
			System.out.println("Desconectado!");
		}
	}

}

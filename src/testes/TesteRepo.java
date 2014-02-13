package testes;

import java.sql.SQLException;
import java.util.Scanner;

import repositorio.RepositorioAtendente;

public class TesteRepo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean conectou = false;
		Scanner in = new Scanner(System.in);
		RepositorioAtendente rep = new RepositorioAtendente("system", "farofa", "jdbc:oracle:thin:@localhost:1521:XE");
		System.out.println("Vamos tentar conectar!");
		try {
			rep.conectar();
			conectou = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conectou) {
			System.out.println("Conectado ao Oracle com sucesso!");
			System.out.println("Digite a consulta: ");
			try {
				String consulta = in.nextLine();
				rep.consultar(consulta);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rep.desconectar();
			System.out.println("Desconectado!");
		}
	}

}

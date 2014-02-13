package objetos;

import java.util.ArrayList;

public class Atendente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4920369337880456185L;
	int guiche;
	
	public Atendente(String nome, String dataNascimento, String sexo,
			String cpf, ArrayList<String> telefones, int guiche) {
		super(nome, dataNascimento, sexo, cpf, telefones);
		this.guiche = guiche;
	}
	
}

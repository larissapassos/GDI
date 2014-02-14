package objetos;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015603264685231840L;
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String cpf;
	public ArrayList<String> telefones;
	
	public Pessoa(String nome, String dataNascimento, String sexo, String cpf,
			ArrayList<String> telefones) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefones = telefones;
	}
	
	
}

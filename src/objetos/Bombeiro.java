package objetos;
import java.util.ArrayList;


public class Bombeiro extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5599433351150472427L;
	String cargo;
	Bombeiro supervisor;
	Posto posto;
	public Bombeiro(String nome, String dataNascimento, String sexo,
			String cpf, ArrayList<String> telefones, String cargo,
			Bombeiro supervisor, Posto posto) {
		super(nome, dataNascimento, sexo, cpf, telefones);
		this.cargo = cargo;
		this.supervisor = supervisor;
		this.posto = posto;
	}
	

	
}

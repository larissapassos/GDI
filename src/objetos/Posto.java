package objetos;
import java.io.Serializable;


public class Posto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4745879615156952573L;
	String codigo;
	String nome;
	Endereco endereco;
	
	public Posto(String codigo, String nome, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	
}

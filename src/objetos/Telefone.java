package objetos;

import java.io.Serializable;

public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -210402161464671847L;
	public String ddd;
	public String numero;
	
	public Telefone(String ddd, String numero){
		this.ddd = ddd;
		this.numero = numero;
	}
}

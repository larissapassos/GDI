package objetos;

import java.io.Serializable;

public class Notifica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7986849197764582951L;
	public Posto posto;
	public Ocorrencia ocorrencia;
	public Atendente atendente;
	public String data;
	
	public Notifica(Posto posto, Ocorrencia ocorrencia, Atendente atendente,
			String data) {
		this.posto = posto;
		this.ocorrencia = ocorrencia;
		this.atendente = atendente;
		this.data = data;
	}
}

package objetos;
import java.io.Serializable;


public class Ocorrencia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3120983315936196267L;
	public String codigo;
	public String tipo;
	public String solicitante;
	public Localizacao localizacao;
	
	public Ocorrencia(String codigo, String tipo, String solicitante,
			Localizacao localizacao) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.solicitante = solicitante;
		this.localizacao = localizacao;
	}
}

package objetos;
import java.io.Serializable;
import java.util.ArrayList;


public class Bombeiro_Ocorrencia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5135212204190079606L;
	String codigo;
	Bombeiro bombeiro;
	Ocorrencia ocorrencia;
	ArrayList<Vitima> lista_vitimas;
	
	public Bombeiro_Ocorrencia(String codigo, Bombeiro bombeiro,
			Ocorrencia ocorrencia, ArrayList<Vitima> lista_vitimas) {
		this.codigo = codigo;
		this.bombeiro = bombeiro;
		this.ocorrencia = ocorrencia;
		this.lista_vitimas = lista_vitimas;
	}

}

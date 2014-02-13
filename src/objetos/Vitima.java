package objetos;
import java.util.ArrayList;


public class Vitima extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8827971432690484732L; 
	String codigo;
	char obito;
	String diagnostico;
	String hospital;
	Ocorrencia ocorrencia;
	ArrayList<Bombeiro_Ocorrencia> bombeiro_ocorrencia;
	
	public Vitima(String nome, String dataNascimento, String sexo, String cpf,
			ArrayList<String> telefones, String codigo, char obito,
			String diagnostico, String hospital, Ocorrencia ocorrencia,
			ArrayList<Bombeiro_Ocorrencia> bombeiro_ocorrencia) {
		super(nome, dataNascimento, sexo, cpf, telefones);
		this.codigo = codigo;
		this.obito = obito;
		this.diagnostico = diagnostico;
		this.hospital = hospital;
		this.ocorrencia = ocorrencia;
		this.bombeiro_ocorrencia = bombeiro_ocorrencia;
	}

}

package objetos;
import java.io.Serializable;


public class Endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2072128236057663220L;
	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;
	
	public Endereco(String logradouro, String numero, String complemento,
			String bairro, String cidade, String estado, String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
}

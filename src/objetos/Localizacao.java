package objetos;

public class Localizacao extends Endereco{
	
	private static final long serialVersionUID = 4432593845095793818L;
	public String pontoReferencia; 
	
	public Localizacao(String logradouro, String numero, String complemento,
			String bairro, String cidade, String estado, String cep, String pontoReferencia) {
		super(logradouro, numero, complemento, bairro, cidade, estado, cep);
		this.pontoReferencia = pontoReferencia;
	}

}

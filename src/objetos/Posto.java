package objetos;
import java.awt.Image;
import java.io.Serializable;


public class Posto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4745879615156952573L;
	public String codigo;
	public String nome;
	public Endereco endereco;
	public Image emblema;
	public String imagePath;
	
	public Posto(String codigo, String nome, Endereco endereco, Image emblema) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.emblema = emblema;
	}
	
	public Posto(String codigo, String nome, Endereco endereco, String imagePath){
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.imagePath = imagePath;
	}
}

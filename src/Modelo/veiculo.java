package Modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculos")
public class veiculo implements Serializable{

	private Long id;
	private String Modelo = "";
	private String Ano = "";
	private loja loja;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "loja")
	public loja getLoja() {
		return loja;
	}
	public void setLoja(loja loja) {
		this.loja = loja;
	}
	
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getAno() {
		return Ano;
	}
	public void setAno(String ano) {
		Ano = ano;
	}


}

package Modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class veiculo implements Serializable{

	private Long id;
	private String Modelo = "";
	private String Ano = "";
	private Class<? extends Object> loja;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Class<? extends Object> getLoja() {
		return this.loja;
	}
	public void setLoja(Object object) {
		this.loja = object.getClass();
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

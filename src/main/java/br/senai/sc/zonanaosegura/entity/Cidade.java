package br.senai.sc.zonanaosegura.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cidade {

	@Id
	@GeneratedValue
	private Long id;
	private String cidade;
	private List<Local> locais;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public List<Local> getLocais() {
		return locais;
	}
	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}
	
}

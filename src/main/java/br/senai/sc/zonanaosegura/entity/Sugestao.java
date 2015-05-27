package br.senai.sc.zonanaosegura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sugestao {

	@Id
	@GeneratedValue
	private Long id;
	private String sugestao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}
	@Override
	public String toString() {
		return "ID:" + id + "\nSugestao" + sugestao;
	}
	
	

}

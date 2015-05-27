package br.senai.sc.zonanaosegura.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Denuncia {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String descricao;
	private Local local;
	private List<Objeto> objetos;
	private TipoCrime tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public List<Objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	public TipoCrime getTipo() {
		return tipo;
	}
	public void setTipo(TipoCrime tipo) {
		this.tipo = tipo;
	}

}

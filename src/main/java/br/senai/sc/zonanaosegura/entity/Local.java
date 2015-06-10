package br.senai.sc.zonanaosegura.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Local {

	@Id
	@GeneratedValue
	private Long id;
	private Float coordenadaX;
	private Float coordenadaY;
	@OneToMany
	private List<Denuncia> denuncias;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Float coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public Float getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Float coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public List<Denuncia> getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}
	
}

package br.senai.sc.zonanaosegura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p") })
public class Usuario_Test {

	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String usuario;
	private String senha;
		
	public Usuario_Test(){
		
	}
	
	public Usuario_Test(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "\nID:" + id + "\nUsuario:" + usuario + "\nSenha:"
				+ senha+"\n";
	}
}
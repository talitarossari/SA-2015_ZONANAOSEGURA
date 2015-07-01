package br.senai.sc.zonanaosegura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String login;
	private String nome;
	private String senha;		
	public Usuario(){
		
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

	public String getNome() {
		return nome;
	}
	
	public void setNome(String usuario) {
		this.nome = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "\nID:" + id + "\nUsuario:" + nome + "\nSenha:"
				+ senha+"\n";
	}
}
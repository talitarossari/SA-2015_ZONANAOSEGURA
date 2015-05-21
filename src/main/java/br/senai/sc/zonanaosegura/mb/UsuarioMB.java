package br.senai.sc.zonanaosegura.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioMB {
	private String login;
	private String nome;
	private String senha;
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String enviar(){
		System.out.println("Nome: " + nome);
		System.out.println("E-Mail: " + login);
			
		nome = "";
		login = "";
			
		return "";
	}
		
	

}

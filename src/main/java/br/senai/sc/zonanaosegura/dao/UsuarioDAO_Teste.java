package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import br.senai.sc.zonanaosegura.entity.Usuario;


public class UsuarioDAO_Teste extends DAOImplements<Usuario>{

	public UsuarioDAO_Teste() {
		super(Usuario.class);
	}
	
	public Usuario salvarCliente(Usuario usuario) {
		save(usuario);
		return usuario;
	}
	
	public List<Usuario> buscaUsuarios() {
		return findAll();
	}
	
}

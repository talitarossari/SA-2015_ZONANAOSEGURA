package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Usuario;


public class UsuarioDao extends Dao {
	public void inserir(Usuario usuario) {
			getEntityManager().merge(usuario);
	}

	public void excluir(Long id) {
		Usuario usuario = getEntityManager().getReference(Usuario.class, id);
		getEntityManager().remove(usuario);
	}

	public void atualizar(Usuario usuario) {
		getEntityManager().merge(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
			Query query = getEntityManager().createQuery("From Usuario", Usuario.class);
			return query.getResultList();
	}
	
	public Usuario buscarPorId(Long id) {
		return getEntityManager().find(Usuario.class, id);
	}
}
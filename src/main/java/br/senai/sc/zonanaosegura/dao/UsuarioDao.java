package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Usuario;


public class UsuarioDao extends Dao {
	public void inserir(Usuario usuario) {
		try {
			getEntityManager().persist(usuario);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Usuario usuario = getEntityManager().getReference(Usuario.class, id);
		getEntityManager().remove(usuario);
	}

	public Usuario buscarPorId(Long id) {
		Usuario usuario = getEntityManager().getReference(Usuario.class, id);
		return usuario;

	}

	public void atualizar(Usuario usuario) {
		try {
			getEntityManager().merge(usuario);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		try {
			Query query = getEntityManager().createQuery("From Usuario",
					Usuario.class);
			List<Usuario> usuarios = (List<Usuario>) query;
			return usuarios;
		} catch (Exception e) {
		}
		return null;
	}
}

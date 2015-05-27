package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Local;

public class LocalDao extends Dao  {

	public void inserir(Local local) {
		try {
			getEntityManager().persist(local);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Local local = getEntityManager().getReference(Local.class, id);
		getEntityManager().remove(local);
	}

	public Local buscarPorId(Long id) {
		return getEntityManager().getReference(Local.class, id);

	}

	public void atualizar(Local local) {
		try {
			getEntityManager().merge(local);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Local> listar() {
		try {
			Query query = getEntityManager().createQuery("From LocalMB",
					Local.class);
			List<Local> locais = (List<Local>) query;
			return locais;
		} catch (Exception e) {
		}
		return null;
	}

}

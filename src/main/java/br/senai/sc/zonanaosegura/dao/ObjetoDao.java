package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Objeto;

public class ObjetoDao  extends Dao  {

	public void inserir(Objeto objeto) {
		try {
			getEntityManager().persist(objeto);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Objeto objeto = getEntityManager().getReference(Objeto.class, id);
		getEntityManager().remove(objeto);
	}

	public Objeto buscarPorId(Long id) {
		return getEntityManager().getReference(Objeto.class, id);

	}

	public void atualizar(Objeto objeto) {
		try {
			getEntityManager().merge(objeto);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Objeto> listar() {
		try {
			Query query = getEntityManager().createQuery("From Objeto",
					Objeto.class);
			List<Objeto> objetos = (List<Objeto>) query;
			return objetos;
		} catch (Exception e) {
		}
		return null;
	}

}

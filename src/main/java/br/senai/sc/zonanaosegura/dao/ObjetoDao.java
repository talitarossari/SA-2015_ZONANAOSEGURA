package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Objeto;

public class ObjetoDao  extends Dao  {

	public void inserir(Objeto objeto) {
			getEntityManager().merge(objeto);
	}

	public void excluir(Long id) {
		Objeto objeto = getEntityManager().getReference(Objeto.class, id);
		getEntityManager().remove(objeto);
	}

	public Objeto buscarPorId(Long id) {
		return getEntityManager().getReference(Objeto.class, id);

	}

	public void atualizar(Objeto objeto) {
			getEntityManager().merge(objeto);

	}
	
	@SuppressWarnings("unchecked")
	public List<Objeto> listar() {
			Query query = getEntityManager().createQuery("From Objeto",
					Objeto.class);
			return query.getResultList();
	}

}

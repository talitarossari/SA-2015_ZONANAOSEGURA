package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.TipoCrime;

public class TipoCrimeDao extends Dao  {

	public void inserir(TipoCrime crime) {
			getEntityManager().merge(crime);
	}

	public void excluir(Long id) {
		TipoCrime crime = getEntityManager().getReference(TipoCrime.class, id);
		getEntityManager().remove(crime);
	}

	public TipoCrime buscarPorId(Long id) {
		return getEntityManager().getReference(TipoCrime.class, id);

	}

	public void atualizar(TipoCrime crime) {
			getEntityManager().merge(crime);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCrime> listar() {
		Query query = getEntityManager().createQuery("From TipoCrime",
				TipoCrime.class);
		return query.getResultList();
	}

}

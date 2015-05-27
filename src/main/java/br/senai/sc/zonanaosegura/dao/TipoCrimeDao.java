package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.TipoCrime;

public class TipoCrimeDao extends Dao  {

	public void inserir(TipoCrime crime) {
		try {
			getEntityManager().persist(crime);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		TipoCrime crime = getEntityManager().getReference(TipoCrime.class, id);
		getEntityManager().remove(crime);
	}

	public TipoCrime buscarPorId(Long id) {
		return getEntityManager().getReference(TipoCrime.class, id);

	}

	public void atualizar(TipoCrime crime) {
		try {
			getEntityManager().merge(crime);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCrime> listar() {
		try {
			Query query = getEntityManager().createQuery("From TipoCrimeMB",
					TipoCrime.class);
			List<TipoCrime> crimes = (List<TipoCrime>) query;
			return crimes;
		} catch (Exception e) {
		}
		return null;
	}

}

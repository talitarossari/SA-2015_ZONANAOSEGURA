package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Sugestao;


public class SugestaoDao  extends Dao {
	public void inserir(Sugestao sugestao) {
		try {
			getEntityManager().persist(sugestao);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Sugestao sugestao = getEntityManager().getReference(Sugestao.class, id);
		getEntityManager().remove(sugestao);
	}

	public Sugestao buscarPorId(Long id) {
		Sugestao sugestao = getEntityManager().getReference(Sugestao.class, id);
		return sugestao;

	}

	public void atualizar(Sugestao sugestao) {
		try {
			getEntityManager().merge(sugestao);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Sugestao> listar() {
		try {
			Query query = getEntityManager().createQuery("From Sugestao",
					Sugestao.class);
			List<Sugestao> sugestoes = (List<Sugestao>) query;
			return sugestoes;
		} catch (Exception e) {
		}
		return null;
	}
}

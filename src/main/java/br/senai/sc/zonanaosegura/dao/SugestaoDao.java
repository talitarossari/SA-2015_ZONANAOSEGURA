package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Sugestao;


public class SugestaoDao  extends Dao {
	public void inserir(Sugestao sugestao) {
			getEntityManager().merge(sugestao);
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
			getEntityManager().merge(sugestao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sugestao> listar() {
			Query query = getEntityManager().createQuery("From Sugestao", Sugestao.class);
			return  query.getResultList();
	}
}

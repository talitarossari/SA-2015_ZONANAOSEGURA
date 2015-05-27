package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Cidade;

public class CidadeDao extends Dao  {

	public void inserir(Cidade cidade) {
		try {
			getEntityManager().persist(cidade);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Cidade cidade = getEntityManager().getReference(Cidade.class, id);
		getEntityManager().remove(cidade);
	}

	public Cidade buscarPorId(Long id) {
		return getEntityManager().getReference(Cidade.class, id);

	}

	public void atualizar(Cidade cidade) {
		try {
			getEntityManager().merge(cidade);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listar() {
		try {
			Query query = getEntityManager().createQuery("From Cidade",
					Cidade.class);
			List<Cidade> cidades = (List<Cidade>) query;
			return cidades;
		} catch (Exception e) {
		}
		return null;
	}
	
}

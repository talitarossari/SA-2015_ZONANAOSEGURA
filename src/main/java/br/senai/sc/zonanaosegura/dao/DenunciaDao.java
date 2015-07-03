package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Denuncia;

public class DenunciaDao extends Dao  {

	public void inserir(Denuncia denuncia) {
			getEntityManager().persist(denuncia);
	}

	public void excluir(Long id) {
		Denuncia denuncia = getEntityManager().getReference(Denuncia.class, id);
		getEntityManager().remove(denuncia);
	}

	public Denuncia buscarPorId(Long id) {
		return getEntityManager().getReference(Denuncia.class, id);

	}

	public void atualizar(Denuncia denuncia) {
			getEntityManager().merge(denuncia);

	}
	
	@SuppressWarnings("unchecked")
	public List<Denuncia> listar() {
		Query query = getEntityManager().createQuery("From Denuncia",
				Denuncia.class);
		return query.getResultList();
	}

}

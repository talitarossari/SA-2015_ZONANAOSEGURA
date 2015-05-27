package br.senai.sc.zonanaosegura.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.zonanaosegura.entity.Denuncia;

public class DenunciaDao extends Dao  {

	public void inserir(Denuncia denuncia) {
		try {
			getEntityManager().persist(denuncia);
		} catch (Exception e) {
		}
	}

	public void excluir(Long id) {
		Denuncia denuncia = getEntityManager().getReference(Denuncia.class, id);
		getEntityManager().remove(denuncia);
	}

	public Denuncia buscarPorId(Long id) {
		return getEntityManager().getReference(Denuncia.class, id);

	}

	public void atualizar(Denuncia denuncia) {
		try {
			getEntityManager().merge(denuncia);
		} catch (Exception e) {
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Denuncia> listar() {
		try {
			Query query = getEntityManager().createQuery("From Denuncia",
					Denuncia.class);
			List<Denuncia> denuncias = (List<Denuncia>) query;
			return denuncias;
		} catch (Exception e) {
		}
		return null;
	}

}

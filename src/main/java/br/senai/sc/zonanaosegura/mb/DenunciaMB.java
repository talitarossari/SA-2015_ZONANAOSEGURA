package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.DenunciaDao;
import br.senai.sc.zonanaosegura.entity.Denuncia;
@ManagedBean
public class DenunciaMB {
	
	private Denuncia denuncia;
	private List<Denuncia> denuncias;
	private DenunciaDao denunciaDao;
	
	@PostConstruct
	public void initMB() {
		this.denuncia = new Denuncia();
		denunciaDao = new DenunciaDao();
	}
	
	
	public Denuncia getDenuncia() {
		return denuncia;
	}


	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}


	public List<Denuncia> getDenuncias() {
		return denuncias;
	}


	public void setDenuncias(List<Denuncia> denuncias) {
		if(denuncias == null){
			denuncias = denunciaDao.listar();
		}
		this.denuncias = denuncias;
	}


	public DenunciaDao getDenunciaDao() {
		return denunciaDao;
	}


	public void setDenunciaDao(DenunciaDao denunciaDao) {
		this.denunciaDao = denunciaDao;
	}

	public String salvar(){
		denunciaDao.inserir(denuncia);
		return "listardenuncias?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		denunciaDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		denuncia = denunciaDao.buscarPorId(id);
		return "cadastrodenuncia";
	}

}

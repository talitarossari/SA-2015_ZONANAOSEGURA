package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.LocalDao;
import br.senai.sc.zonanaosegura.entity.Local;
@ManagedBean
public class LocalMB {
	
	private Local local;
	private List<Local> locais;
	private LocalDao localDao;
	
	@PostConstruct
	public void initMB() {
		this.local = new Local();
		localDao = new LocalDao();
	}
	
	
	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


	public List<Local> getLocais() {
		return locais;
	}


	public void setLocais(List<Local> locais) {
		if(locais == null){
			locais = localDao.listar();
		}
		this.locais = locais;
	}


	public LocalDao getLocalDao() {
		return localDao;
	}


	public void setLocalDao(LocalDao localDao) {
		this.localDao = localDao;
	}

	public String salvar(){
		localDao.inserir(local);
		return "listarusuarios?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		localDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		local = localDao.buscarPorId(id);
		return "cadastrousuario";
	}

}

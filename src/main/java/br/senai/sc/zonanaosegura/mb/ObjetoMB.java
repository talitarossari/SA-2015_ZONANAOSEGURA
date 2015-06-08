package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.ObjetoDao;
import br.senai.sc.zonanaosegura.entity.Objeto;
@ManagedBean
public class ObjetoMB  {
	
	private Objeto objeto;
	private List<Objeto> objetos;
	private ObjetoDao objetoDao;
	
	@PostConstruct
	public void initMB() {
		this.objeto = new Objeto();
		objetoDao = new ObjetoDao();
	}
	
	
	public Objeto getObjeto() {
		return objeto;
	}


	public void setObjeto(Objeto local) {
		this.objeto = local;
	}


	public List<Objeto> getObjetos() {
		return objetos;
	}


	public void setObjetos(List<Objeto> locais) {
		if(locais == null){
			locais = objetoDao.listar();
		}
		this.objetos = locais;
	}


	public ObjetoDao getLocalDao() {
		return objetoDao;
	}


	public void setDenunciaDao(ObjetoDao localDao) {
		this.objetoDao = localDao;
	}

	public String salvar(){
		objetoDao.inserir(objeto);
		return "listarobjetos?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		objetoDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		objeto = objetoDao.buscarPorId(id);
		return "cadastroobjeto";
	}
}

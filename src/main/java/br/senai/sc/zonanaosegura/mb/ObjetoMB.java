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


	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}


	public List<Objeto> getObjetos() {
		if(objetos == null){
			objetos = objetoDao.listar();
		}
		return objetos;
	}


	public void setObjetos(List<Objeto> objetos) {

		this.objetos = objetos;
	}


	public ObjetoDao getObjetoDao() {
		return objetoDao;
	}


	public void setDenunciaDao(ObjetoDao objetoDao) {
		this.objetoDao = objetoDao;
	}

	public String salvar(){
		objetoDao.inserir(objeto);
		return "objeto?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		objetoDao.excluir(id);
		return "objeto?faces-redirect=true";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		objeto = objetoDao.buscarPorId(id);
		return "addobjeto";
	}
}

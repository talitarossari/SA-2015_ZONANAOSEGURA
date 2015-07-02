package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.DenunciaDao;
import br.senai.sc.zonanaosegura.dao.ObjetoDao;
import br.senai.sc.zonanaosegura.dao.TipoCrimeDao;
import br.senai.sc.zonanaosegura.entity.Denuncia;
import br.senai.sc.zonanaosegura.entity.Objeto;
import br.senai.sc.zonanaosegura.entity.TipoCrime;
@ManagedBean
public class DenunciaMB {
	
	private Denuncia denuncia;
	private List<Denuncia> denuncias;
	private DenunciaDao denunciaDao;
	private List<TipoCrime> tipos;
	private List<Objeto> objetos;
	
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

	public List<TipoCrime> getTipos() {
		if(tipos == null){
			TipoCrimeDao tipoCrimeDao = new TipoCrimeDao();
			tipos = tipoCrimeDao.listar();
		}
		return tipos;
	}

	public void setTipos(List<TipoCrime> tipos) {
		this.tipos = tipos;
	}
	
	public List<Objeto> getObjetos() {
		if(objetos == null){
			ObjetoDao objetoDao = new ObjetoDao();
			objetos = objetoDao.listar();
		}
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
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
	
	public void buscarPorCidade(){
		
	}

}

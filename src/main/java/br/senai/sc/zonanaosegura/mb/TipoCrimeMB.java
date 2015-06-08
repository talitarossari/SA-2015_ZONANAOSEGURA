package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.TipoCrimeDao;
import br.senai.sc.zonanaosegura.entity.TipoCrime;

@ManagedBean
public class TipoCrimeMB  {
	
	private TipoCrime tipo;
	private List<TipoCrime> tipos;
	private TipoCrimeDao tipoDao;
	
	@PostConstruct
	public void initMB() {
		this.tipo = new TipoCrime();
		tipoDao = new TipoCrimeDao();
	}
	
	
	public TipoCrime getTipoCrime() {
		return tipo;
	}


	public void setTipoCrime(TipoCrime local) {
		this.tipo = local;
	}


	public List<TipoCrime> getTipoCrimes() {
		return tipos;
	}


	public void setTipoCrimes(List<TipoCrime> locais) {
		if(locais == null){
			locais = tipoDao.listar();
		}
		this.tipos = locais;
	}


	public TipoCrimeDao getTipoCrimeDao() {
		return tipoDao;
	}


	public void setTipoCrimeDao(TipoCrimeDao tipoCrimeDao) {
		this.tipoDao = tipoCrimeDao;
	}

	public String salvar(){
		tipoDao.inserir(tipo);
		return "listarusuarios?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		tipoDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		tipo = tipoDao.buscarPorId(id);
		return "cadastrousuario";
	}

}

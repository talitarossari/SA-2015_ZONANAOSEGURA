package br.senai.sc.zonanaosegura.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.senai.sc.zonanaosegura.dao.ObjetoDao;
import br.senai.sc.zonanaosegura.entity.Objeto;
import br.senai.sc.zonanaosegura.util.UploadImageException;
import br.senai.sc.zonanaosegura.util.UploadImageUtil;

@ManagedBean
public class ObjetoMB  {
	
	private Objeto objeto;
	private List<Objeto> objetos;
	private ObjetoDao objetoDao;
	private Part icone;
	
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

	public Part getIcone() {
		return icone;
	}


	public void setIcone(Part icone) {
		this.icone = icone;
	}


	public void setDenunciaDao(ObjetoDao objetoDao) {
		this.objetoDao = objetoDao;
	}

	public String salvar(){
		String nomeLogo;
		try {
			nomeLogo = UploadImageUtil.salvar(icone, objeto.getLogo());
			objeto.setLogo(nomeLogo);
		} catch (UploadImageException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel salvar a imagem."));
			e.printStackTrace();
			return "";
		}
		
		objetoDao.inserir(objeto);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		return "objeto?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		
		Objeto objetoExcluir = objetoDao.buscarPorId(id);
		UploadImageUtil.excluir(objetoExcluir.getLogo());
		
		objetoDao.excluir(id);
		objetos = null;
		return "objeto?faces-redirect=true";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		objeto = objetoDao.buscarPorId(id);
		return "addobjeto";
	}
	

	public String caminhoUpload(String imagem){
		return UploadImageUtil.getCaminhoRelativo(imagem);
	}
	
	
	
}

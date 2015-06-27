package br.senai.sc.zonanaosegura.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.senai.sc.zonanaosegura.dao.TipoCrimeDao;
import br.senai.sc.zonanaosegura.entity.TipoCrime;
import br.senai.sc.zonanaosegura.util.UploadImageException;
import br.senai.sc.zonanaosegura.util.UploadImageUtil;

@ManagedBean
public class TipoCrimeMB {

	private TipoCrime tipo;
	private List<TipoCrime> tipos;
	private TipoCrimeDao tipoDao;
	private Part icone;
	private UploadImageUtil uploadImageUtil;

	@PostConstruct
	public void initMB() {
		this.tipo = new TipoCrime();
		tipoDao = new TipoCrimeDao();
		this.uploadImageUtil = new UploadImageUtil("iconesTipo/");
	}

	public TipoCrime getTipo() {
		return tipo;
	}

	public void setTipo(TipoCrime tipo) {
		this.tipo = tipo;
	}

	public List<TipoCrime> getTipos() {
		if (tipos == null) {
			tipos = tipoDao.listar();
		}
		return tipos;
	}

	public void setTipos(List<TipoCrime> tipos) {
		this.tipos = tipos;
	}

	public TipoCrimeDao getTipoDao() {
		return tipoDao;
	}

	public void setTipoDao(TipoCrimeDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	public Part getIcone() {
		return icone;
	}

	public void setIcone(Part icone) {
		this.icone = icone;
	}

	public UploadImageUtil getUploadImageUtil() {
		return uploadImageUtil;
	}

	public void setUploadImageUtil(UploadImageUtil uploadImageUtil) {
		this.uploadImageUtil = uploadImageUtil;
	}

	public String salvar() {
		String nomeLogo;
		try {
			nomeLogo = uploadImageUtil.salvar(icone, tipo.getIcone());
			tipo.setIcone(nomeLogo);
		} catch (UploadImageException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Nao foi possivel salvar a imagem."));
			e.printStackTrace();
			return "";
		}

		tipoDao.inserir(tipo);
		return "tipoCrime?faces-redirect=true";
	}

	public String excluir(String idParam) {
		Long id = Long.valueOf(idParam);
		TipoCrime tipoExcluir = tipoDao.buscarPorId(id);
		uploadImageUtil.excluir(tipoExcluir.getIcone());
		tipoDao.excluir(id);
		return "tipoCrime?faces-redirect=true";
	}

	public String editar(String idParam) {
		Long id = Long.valueOf(idParam);
		tipo = tipoDao.buscarPorId(id);
		return "addTipoCrime?faces-redirect=true";
	}

	public String caminhoUpload(String imagem) {
		return uploadImageUtil.getCaminhoRelativo(imagem);
	}

}

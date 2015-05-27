package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;

import br.senai.sc.zonanaosegura.dao.CidadeDao;
import br.senai.sc.zonanaosegura.entity.Cidade;

public class DenunciaMB {
	
/*	private Denuncia cidade;
	private List<Denuncia> cidades;
	private DenunciaDao cidadeDao;
	
	@PostConstruct
	public void initMB() {
		this.cidade = new Denuncia();
		cidadeDao = new DenunciaDao();
	}
	
	
	public Denuncia getDenuncia() {
		return cidade;
	}


	public void setDenuncia(Denuncia cidade) {
		this.cidade = cidade;
	}


	public List<Denuncia> getDenuncias() {
		return cidades;
	}


	public void setDenuncias(List<Denuncia> usuarios) {
		if(usuarios == null){
			usuarios = cidadeDao.listar();
		}
		this.cidades = usuarios;
	}


	public DenunciaDao getDenunciaDao() {
		return cidadeDao;
	}


	public void setDenunciaDao(DenunciaDao usuarioDao) {
		this.cidadeDao = usuarioDao;
	}

	public String salvar(){
		cidadeDao.inserir(cidade);
		return "listarusuarios?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		cidadeDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		cidade = cidadeDao.buscarPorId(id);
		return "cadastrousuario";
	}
*/
}

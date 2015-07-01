package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.zonanaosegura.dao.CidadeDao;
import br.senai.sc.zonanaosegura.entity.Cidade;
@ManagedBean
public class CidadeMB {
	
	private Cidade cidade;
	private List<Cidade> cidades;
	private CidadeDao cidadeDao;
	
	@PostConstruct
	public void initMB() {
		this.cidade = new Cidade();
		cidadeDao = new CidadeDao();
	}
	
	
	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> usuarios) {
		if(usuarios == null){
			usuarios = cidadeDao.listar();
		}
		this.cidades = usuarios;
	}


	public CidadeDao getCidadeDao() {
		return cidadeDao;
	}


	public void setCidadeDao(CidadeDao usuarioDao) {
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
	
}

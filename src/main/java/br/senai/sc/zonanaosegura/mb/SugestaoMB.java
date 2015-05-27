package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;

import br.senai.sc.zonanaosegura.dao.SugestaoDao;
import br.senai.sc.zonanaosegura.entity.Sugestao;

public class SugestaoMB {

	private Sugestao sugestao;
	private List<Sugestao> sugestoes;
	private SugestaoDao sugestaoDao;
	
	@PostConstruct
	public void initMB() {
		this.sugestao = new Sugestao();
		sugestaoDao = new SugestaoDao();
	}
	
	
	public Sugestao getSugestao() {
		return sugestao;
	}


	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}


	public List<Sugestao> getSugestoes() {
		return sugestoes;
	}


	public void setSugestoes(List<Sugestao> sugestao) {
		if(sugestao == null){
			sugestao = sugestaoDao.listar();
		}
		this.sugestoes = sugestao;
	}


	public SugestaoDao getSugestaoDao() {
		return sugestaoDao;
	}


	public void setSugestaoDao(SugestaoDao sugestaoDao) {
		this.sugestaoDao = sugestaoDao;
	}

	public String salvar(){
		sugestaoDao.inserir(sugestao);
		return "listarusuarios?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		sugestaoDao.excluir(id);
		return "";
	}

	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		sugestao = sugestaoDao.buscarPorId(id);
		return "cadastrousuario";
	}
	
}

package br.senai.sc.zonanaosegura.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import br.senai.sc.zonanaosegura.dao.UsuarioDao;
import br.senai.sc.zonanaosegura.entity.Usuario;


@ManagedBean
@SessionScoped
public class SessaoMB {

	private Usuario usuarioForm;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init(){
		usuarioForm = new Usuario();
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public String login(){
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscaPorLogin(usuarioForm.getLogin());
		try{
			if(checkLogin(usuario)){
				usuarioLogado = usuario;
				return "/admin/index?faces-redirect=true";
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ou senha invalida."));
			return "/login";
		} catch(PersistenceException e) {
			return "";
		}
	}
	
	private boolean checkLogin(Usuario usuarioEncontrado) {
		return usuarioEncontrado != null 
				&& usuarioForm.getLogin().equalsIgnoreCase(usuarioEncontrado.getLogin()) 
				&& usuarioForm.getSenha().equals(usuarioEncontrado.getSenha());
	}
	
	public String logout(){
		usuarioLogado = null;
		return "/index?face-redirect=true";
	}

	public Usuario getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
}

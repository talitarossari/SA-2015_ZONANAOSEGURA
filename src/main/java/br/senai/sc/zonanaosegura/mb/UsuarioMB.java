package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.zonanaosegura.dao.UsuarioDao;
import br.senai.sc.zonanaosegura.entity.Usuario;

@ManagedBean
public class UsuarioMB {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private UsuarioDao usuarioDao;

	@PostConstruct
	public void initMB() {
		this.usuario = new Usuario();
		usuarioDao = new UsuarioDao();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = usuarioDao.listarTodos();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;

	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public String salvar() {
		if (usuario.getId() != null && usuario.getSenha() == null
				|| usuario.getSenha() == "" || usuario.getSenha().isEmpty()) {
			Usuario usu = usuarioDao.buscarPorId(usuario.getId());
			usuario.setSenha(usu.getSenha());
		} else if ((usuario.getId() == null)
				&& (usuario.getSenha() == null || usuario.getSenha() == ""
						|| usuario.getSenha().isEmpty()
						|| usuario.getLogin() == null
						|| usuario.getLogin() == ""
						|| usuario.getLogin().isEmpty()
						|| usuario.getUsuario() == null
						|| usuario.getUsuario() == "" || usuario.getUsuario()
						.isEmpty())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Preencha todos os campos!"));

		} else if (usuarioDao.buscaPorLogin(usuario.getLogin())!=null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esse usuario ja existe!"));
		}

		usuarioDao.inserir(usuario);
		return "usuario?faces-redirect=true";
	}

	public String excluir(String idParam) {
		Long id = Long.valueOf(idParam);
		usuarioDao.excluir(id);
		return "usuario?faces-redirect=true";
	}

	public String editar(String idParam) {
		Long id = Long.valueOf(idParam);
		usuario = usuarioDao.buscarPorId(id);
		return "addusuario";
	}

}

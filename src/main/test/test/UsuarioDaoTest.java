package test;

import br.senai.sc.zonanaosegura.dao.UsuarioDao;
import br.senai.sc.zonanaosegura.entity.Usuario;

public class UsuarioDaoTest {

	private static UsuarioDao usuarioDao;
	private static Usuario usuario1;
	
	public static void inicializaVariavel(){
		usuarioDao= new UsuarioDao();
		usuario1 = new Usuario();
	}
	
	public void testInserir(){
		Usuario usuario1 = new Usuario();
		usuario1.setUsuario("Talita_Rossari");
		usuario1.setSenha("TalitaRossari");
	}
	
	
	
}

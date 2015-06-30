package br.senai.sc.zonanaosegura.util;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;



public class UploadImageUtil {
	private final String DIRETORIO_IMAGENS;
	private static final Map<String, String> TIPOS_PERMITIDOS = new HashMap<String, String>();
	
	static{
		TIPOS_PERMITIDOS.put("image/gif", "gif");
		TIPOS_PERMITIDOS.put("image/png", "png");
		TIPOS_PERMITIDOS.put("image/jpeg", "jpg");
		TIPOS_PERMITIDOS.put("image/pjpeg", "jpg");
	}

	public UploadImageUtil(String diretorio){
		DIRETORIO_IMAGENS = "/resources/img/".concat(diretorio);
	}
	
	public String salvar(Part imagem, String imagemAntiga) throws UploadImageException, IOException {
		if(imagem == null){
			return imagemAntiga;
		}
		
		if(!TIPOS_PERMITIDOS.containsKey(imagem.getContentType())){
			throw new UploadImageException("O tipo de arquivo nao permitido.");
		}
		
		String nomeImagem = gerarNomeImagem(imagem);
		
		imagem.write(getCaminhoAbsoluto(nomeImagem));
		
		excluir(imagemAntiga);
		
		return nomeImagem;
	}

	public  void excluir(String imagemAntiga) {
		if(imagemAntiga == null){
			return;
		}
		
		File arquivo = new File(getCaminhoAbsoluto(imagemAntiga));
		if(arquivo.exists()){
			arquivo.delete();
		}
	}

	private  String getCaminhoAbsoluto(String nomeImagem) {
		String caminhoImagem = DIRETORIO_IMAGENS.concat(nomeImagem);
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
		String caminhoAbsoluto = servletContext.getRealPath(caminhoImagem);
		
		return caminhoAbsoluto;
	}

	private static String gerarNomeImagem(Part imagem) {
		
		String novoNome = UUID.randomUUID().toString();
		return novoNome.concat("." + TIPOS_PERMITIDOS.get(imagem.getContentType()));
	}

	public  String getCaminhoRelativo(String imagem) {
		return DIRETORIO_IMAGENS.concat(imagem);
	}

}

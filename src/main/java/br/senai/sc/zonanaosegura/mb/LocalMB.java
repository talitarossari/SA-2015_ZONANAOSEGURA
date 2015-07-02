package br.senai.sc.zonanaosegura.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;

import jdk.nashorn.internal.parser.JSONParser;
import br.senai.sc.zonanaosegura.dao.LocalDao;
import br.senai.sc.zonanaosegura.entity.Local;



@ManagedBean
public class LocalMB {
	private static final String NOT_AVAILABLE = "Not available";
	private String latitude;
	private String longitude;  
	private Local local;
	private List<Local> locais;
	private LocalDao localDao;
	private String MarkerStatus;
	private String LocalInforma;
	

	public String getLatitude() {
		if (latitude == null) {
			latitude = "-25";
		}
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		if (longitude == null) {
			longitude = "-51.6588";
		}
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String save() {
		System.out.println("Latitude: " + latitude);
		System.out.println("Longitude: " + longitude);
		return "";
	}



	@PostConstruct
	public void initMB() {
		this.local = new Local();
		localDao = new LocalDao();
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		if (locais == null) {
			locais = localDao.listar();
		}
		this.locais = locais;
	}

	public LocalDao getLocalDao() {
		return localDao;
	}

	public void setLocalDao(LocalDao localDao) {
		this.localDao = localDao;
	}

	public String salvar() {
		localDao.inserir(local);
		return "listarusuarios?faces-redirect=true";
	}

	public String excluir(String idParam) {
		Long id = Long.valueOf(idParam);
		localDao.excluir(id);
		return "";
	}

	public String editar(String idParam) {
		Long id = Long.valueOf(idParam);
		local = localDao.buscarPorId(id);
		return "cadastrousuario";
	}

	public String getMarkerStatus() {
		return MarkerStatus;
	}

	public void setMarkerStatus(String markerStatus) {
		MarkerStatus = markerStatus;
	}

	public String getLocalInforma() {
		return LocalInforma;
	}

	public void setLocalInforma(String localinforma) {
		LocalInforma = localinforma;
	}

	public static String getNotAvailable() {
		return NOT_AVAILABLE;
	}

}

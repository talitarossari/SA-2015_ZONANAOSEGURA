package br.senai.sc.zonanaosegura.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.zonanaosegura.dao.ObjetoDao;
import br.senai.sc.zonanaosegura.entity.Objeto;


@FacesConverter(forClass=Objeto.class)
public class ObjetoConverter implements Converter {

	@Override
	public Object  getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		ObjetoDao dao = new ObjetoDao();
		Long id = Long.valueOf(value);
		return  dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value)  {
		Objeto objeto = (Objeto) value;
		return objeto.getId().toString();
	}

}

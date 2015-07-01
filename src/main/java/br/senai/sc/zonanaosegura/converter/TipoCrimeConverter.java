package br.senai.sc.zonanaosegura.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.zonanaosegura.dao.TipoCrimeDao;
import br.senai.sc.zonanaosegura.entity.TipoCrime;

@FacesConverter(forClass=TipoCrime.class)
public class TipoCrimeConverter implements Converter {

	@Override
	public Object  getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		TipoCrimeDao dao = new TipoCrimeDao();
		Long id = Long.valueOf(value);
		return  dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object value)  {
		TipoCrime tipo = (TipoCrime) value;
		return tipo.getId().toString();
	}

}

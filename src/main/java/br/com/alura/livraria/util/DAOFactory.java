package br.com.alura.livraria.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.alura.livraria.dao.DAO;

@SuppressWarnings("unchecked")
public class DAOFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	public <T> DAO<T> factory(InjectionPoint point){
		ParameterizedType type = (ParameterizedType)point.getType();
		
		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		
		return new DAO<T>(classe);
		
	}
}

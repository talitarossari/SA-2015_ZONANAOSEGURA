package br.senai.sc.zonanaosegura.dao.test;

import java.util.List;


public interface DAO_Test<T> {

	public void save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public void deleteAll(List<T> t);
	
	public T findAllById(Integer id);
	
	public List<T> findAll();
	
}


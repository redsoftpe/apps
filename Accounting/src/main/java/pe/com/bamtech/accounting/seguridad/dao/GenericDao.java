package pe.com.bamtech.accounting.seguridad.dao;

import java.io.Serializable;
/**
 * 
 * @author Carlos Carreño
 * Interface Generica para crear las interfaces DAO.
 * @param <T>
 * @param <K>
 */

public interface GenericDao<T, K extends Serializable> {
	
	  T create(T entity);

	  T update(T entity);

	  void delete(T entity);

	  T findById(K key);
	  
	  void delete(K key);
	
}

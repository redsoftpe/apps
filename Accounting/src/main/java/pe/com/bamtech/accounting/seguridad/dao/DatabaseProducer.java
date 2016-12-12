package pe.com.bamtech.accounting.seguridad.dao;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {

	@Produces
	@DatabaseContable
	@PersistenceContext(unitName="PUAccounting")
	private EntityManager entityManager; 
	
}

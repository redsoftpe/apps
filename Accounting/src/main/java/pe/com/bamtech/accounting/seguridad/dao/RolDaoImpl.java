package pe.com.bamtech.accounting.seguridad.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import pe.com.bamtech.accounting.seguridad.domain.Rol;


/**
 * @author Carlos Carreño
 * Implementa los metodos para la persistencia de las entidades Usuario
 *
 */
@Named
public class RolDaoImpl implements RolDao {

	@Inject
	@DatabaseContable
	private EntityManager entityManager;
	
	@Override
	public Rol create(Rol entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Rol update(Rol entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(Rol entity) {
		delete(entity.getRolename());

	}

	@Override
	public Rol findById(String key) {
		Rol rol = entityManager.find(Rol.class, key); 
		return rol;
	}

	@Override
	public void delete(String key) {
		Rol rol = findById(key);
		entityManager.remove(rol);
	}

	public List<Rol> getAllRows() {
		return entityManager.createQuery("Select r From  Rol r")
	                        .getResultList();
	}

}

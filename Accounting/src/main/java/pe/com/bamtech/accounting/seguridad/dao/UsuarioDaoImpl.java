package pe.com.bamtech.accounting.seguridad.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import pe.com.bamtech.accounting.seguridad.domain.Usuario;


/**
 * @author Carlos Carreño
 * Implementa los metodos para la persistencia de las entidades Usuario
 *
 */
@Named
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
	@DatabaseContable
	private EntityManager entityManager;
	
	@Override
	public Usuario create(Usuario entity) {
		System.out.print("username"+entity.getUsername());
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Usuario update(Usuario entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(Usuario entity) {
		delete(entity.getUsername());
	}

	@Override
	public Usuario findById(String key) {
		Usuario usuario = entityManager.find(Usuario.class, key); 
		return usuario;
	}

	@Override
	public void delete(String key) {
		Usuario usuario = findById(key);
		entityManager.remove(usuario);
	}

	@Override
	public List<Usuario> getUsuarioByNombre(String nombre) {
		// TODO Aun no implementado, por realizar.
		return null;
	}

	public List<Usuario> getAllRows() {
		return entityManager.createQuery("Select O From  Usuario O order by O.username") //Select U From User U order by U.username
				            .getResultList();
	}

	
	
	public List<Usuario> getByUsername(String username){
		if(username==null) username="";
		
		return entityManager.createQuery("Select O From Usuario O Where O.username LIKE :username")
				.setParameter("username", "%"+username.toUpperCase() +"%")
				.getResultList();
	}
	
	
	
}

package pe.com.bamtech.accounting.seguridad.dao;

import java.util.List;

import pe.com.bamtech.accounting.seguridad.domain.Usuario;


public interface UsuarioDao extends GenericDao<Usuario, String> {

	List<Usuario> getUsuarioByNombre(String nombre);

	List<Usuario> getAllRows();
	
	
	
}

package pe.com.bamtech.accounting.seguridad.dao;

import java.util.List;

import pe.com.bamtech.accounting.seguridad.domain.Rol;


public interface RolDao extends GenericDao<Rol, String> {

	List<Rol> getAllRows();

}

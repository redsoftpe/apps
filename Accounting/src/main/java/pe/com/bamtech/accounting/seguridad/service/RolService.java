package pe.com.bamtech.accounting.seguridad.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.bamtech.accounting.seguridad.dao.RolDao;
import pe.com.bamtech.accounting.seguridad.domain.Rol;

@Named
@Stateless
public class RolService {

	 @Inject
	 private RolDao dao;
	
	 public Rol create(Rol entity){
			return dao.create(entity);
		}
	
		public List<Rol> getAllEntities(){
			List<Rol> RolList = dao.getAllRows();
			return RolList;
		}

		public void update(Rol Rol) {
			dao.update(Rol);
		}

		public void delete(String key) {
			dao.delete(key);
		}
		
		public Rol find(String key){
		   return dao.findById(key);	
		}
	 
}

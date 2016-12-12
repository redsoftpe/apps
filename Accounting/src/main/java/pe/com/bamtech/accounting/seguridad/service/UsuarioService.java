package pe.com.bamtech.accounting.seguridad.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.bamtech.accounting.seguridad.dao.UsuarioDao;
import pe.com.bamtech.accounting.seguridad.domain.Usuario;

@Named
@Stateless
public class UsuarioService {

	 @Inject
	 private UsuarioDao dao;
	
	 public Usuario create(Usuario entity){
			return dao.create(entity);
		}
	
		public List<Usuario> getAllEntities(){
			List<Usuario> UsuarioList = dao.getAllRows();
			return UsuarioList;
		}

		
		public List<Usuario> getBusquedaUsername(String usuario){
			List<Usuario> usuarioList = dao.getUsuarioByNombre(usuario);
			return usuarioList;
		}
		
			
		public void update(Usuario Usuario) {
			dao.update(Usuario);
		}

		public void delete(String key) {
			dao.delete(key);
		}
		
		public Usuario find(String key){
		   return dao.findById(key);	
		}
	 
}

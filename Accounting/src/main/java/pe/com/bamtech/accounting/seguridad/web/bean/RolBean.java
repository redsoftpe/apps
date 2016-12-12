package pe.com.bamtech.accounting.seguridad.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.bamtech.accounting.seguridad.domain.Rol;
import pe.com.bamtech.accounting.seguridad.service.RolService;
import pe.com.bamtech.accounting.seguridad.web.util.Utilidad;

@Named
@SessionScoped
public class RolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Rol> lista=null;
    private Rol entity=null;
    
    @Inject
	private RolService service;
	
	private Utilidad util=new Utilidad();
	
	@PostConstruct 
	public void init(){
		lista=service.getAllEntities();		
	}

	public List<Rol> getLista() {
		lista=service.getAllEntities();	
		return lista;
	}

	public void setLista(List<Rol> lista) {
		this.lista = lista;
	}

	public Rol getEntity() {
		return entity;
	}

	public void setEntity(Rol entity) {
		this.entity = entity;
	}
	
	
	public String prepareNew(){
		entity=new Rol();
		return "nuevoRol?faces-redirect=true";
	}
	
	public String prepareEdit(Rol rol){
		entity=rol;
		return "editarRol?faces-redirect=true";
	}
	
	public String update(){
		service.update(entity);
	    return "listarRol?faces-redirect=true";
	}
	
	public String create(){
		String id=service.create(entity).getRolename();
		return "listarRol?faces-redirect=true";
	}
	
	public String goList(){
		return "/private/seguridad/rol/listarRol?faces-redirect=true";
	}
	
	
	public void prepareDelete(Rol rol){
		entity=rol;
		service.delete(entity.getRolename());
		util.addMessage("Se elimino un rol, con exito.");
	}
		
}

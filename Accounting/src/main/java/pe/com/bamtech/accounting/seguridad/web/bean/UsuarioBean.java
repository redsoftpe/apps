package pe.com.bamtech.accounting.seguridad.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import pe.com.bamtech.accounting.seguridad.domain.Rol;
import pe.com.bamtech.accounting.seguridad.domain.Usuario;
import pe.com.bamtech.accounting.seguridad.service.RolService;
import pe.com.bamtech.accounting.seguridad.service.UsuarioService;
import pe.com.bamtech.accounting.seguridad.web.util.Utilidad;

@Named
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Usuario> lista=null;
    private Usuario entity=null;
	
    @Inject
    private UsuarioService service;
	
    @Inject
	private RolService rolService;
	
    private DualListModel<Rol> rolModel;
	private List<Rol> targetRol;
	private List<Rol> sourceRol;
	
	private Utilidad util=new Utilidad();
	
	@PostConstruct 
	public void init(){
		lista=service.getAllEntities();		
		targetRol=new ArrayList<Rol>();
		setSourceRol(rolService.getAllEntities());
		rolModel=new DualListModel<Rol>(getSourceRol(),targetRol);
	}

	public List<Usuario> getLista() {
		lista=service.getAllEntities();	
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}
	
	
	public String prepareNew(){
		entity=new Usuario();
		return "nuevoUsuario?faces-redirect=true";
	}
	
	public String prepareEdit(Usuario usuario){
		entity=usuario;
		return "listarUsuario?faces-redirect=true";
	}
	
	public String update(){
		service.update(entity);
	    return "listarUsuario?faces-redirect=true";
	}
	
	public String create(){
		String id=service.create(entity).getUsername();
		return "listarUsuario?faces-redirect=true";
	}
	
	public String goList(){
		return "/private/seguridad/usuario/listarUsuario?faces-redirect=true";
	}
	
	public String goListMembresia(){
		return "/private/seguridad/membresia/listarMembresia?faces-redirect=true";
	}
	
	public void prepareDelete(Usuario usuario){
		entity=usuario;
		service.delete(entity.getUsername());
		util.addMessage("Se elimino un registro de Usuario.");
	}
	
	public String getRolesString(Usuario usuario){
		String permisos="";
		int k=1;
		System.out.println("rol size:"+usuario.getRols().size());
		for(Rol r:usuario.getRols()){
			if(k>1){
			  permisos=permisos+", "+r.getRolename();
			}else{
			  permisos=r.getRolename();	
			}
			k++;
		}
		return permisos;		
	}

	public DualListModel<Rol> getRolModel() {
		return rolModel;
	}

	public void setRolModel(DualListModel<Rol> rolModel) {
		this.rolModel = rolModel;
	}

	public List<Rol> getTargetRol() {
		return targetRol;
	}

	public void setTargetRol(List<Rol> targetRol) {
		this.targetRol = targetRol;
	}

	public List<Rol> getSourceRol() {
		return sourceRol;
	}

	public void setSourceRol(List<Rol> sourceRol) {
		this.sourceRol = sourceRol;
	}
	
	
	public void onTransferMembresia(TransferEvent event){
		System.out.println("onTransferMembresia");
		if(event.isAdd()){			
			for(Rol p:(List<Rol>)event.getItems()){
				 getTargetRol().add(p);
			}
		}
		if(event.isRemove()){
			for(Rol o:(List<Rol>)event.getItems()){
				getTargetRol().remove(o);
			}
		}		
	}
	
	public String prepareMembresiaEdit(Usuario usuario){
		this.entity=usuario;
		setTargetRol(getEntity().getRols());
		getRolModel().setTarget(getTargetRol());
		getRolModel().setSource(rolService.getAllEntities());
		removeTargetPoblacionObjetivo(getRolModel().getSource(),getRolModel().getTarget());
		return "/private/seguridad/membresia/editarMembresia?faces-redirect=true";
	}
	
	public void removeTargetPoblacionObjetivo(List<Rol> source,List<Rol> target){
		for(Rol p:target){
			source.remove(p);
		}
	}
	
	public String backtoMembresiaList(){
		return "/private/seguridad/membresia/listarMembresia?faces-redirect=true";
	}	
	
	public String updateMembresia(){
		entity.setRols(getRolModel().getTarget());
		for(Rol r:entity.getRols()){
	     	System.out.println("rol:"+r.getRolename());
		}
		service.update(entity);
		return "/private/seguridad/membresia/listarMembresia?faces-redirect=true";
	}
	
	public Usuario getUsuarioByUsername(String username){
		Usuario usuario=null;
		usuario  = service.find(username);
		return usuario;
	}
	
}

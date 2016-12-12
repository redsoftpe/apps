package pe.com.bamtech.accounting.seguridad.web.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.jboss.logging.Logger;

import pe.com.bamtech.accounting.seguridad.web.util.Utilidad;

import java.io.Serializable;




@Named
@SessionScoped
public class SesionBean implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(SesionBean.class);
	
	private static final long serialVersionUID = 1L;
	private String username=new String();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@PostConstruct
	public void init(){
		setUsername(Utilidad.getUsuarioAutenticado());
		LOGGER.info(">> Usuario autenticado con la cuenta:"+getUsername());
	}
    
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/private/default?faces-redirect=true";
	}
	
	public boolean isAutenticate(){
		if (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null )
			return true;
		else
			return false;
	}
	
	
}



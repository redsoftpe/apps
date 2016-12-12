package pe.com.bamtech.accounting.seguridad.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Utilidad {
	
	public static Utilidad utilidad = null;
	
	public static final Utilidad getInstance(){
		if(utilidad == null )
		   utilidad = new Utilidad();
		return utilidad;
	} 
			
	public void addMessage(String cuerpoMensaje) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, cuerpoMensaje,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
	
	public static String getUsuarioAutenticado(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        String username = ( externalContext.getUserPrincipal() != null ) ? externalContext.getUserPrincipal().getName():"no-autenticado";
        return username;
    }

	public static String transformarArregloACadena(String[] arreglo,String separador){
		String result="";
		for(int i=0;i<arreglo.length;i++){
			result=result+arreglo[i];
			if(i<(arreglo.length-1)){
				result=result+separador;
			}
		}	
		return result;
	}
	
	public static String getParametro(String nombreParametro){
		String stringParametro=null;
		stringParametro=FacesContext.getCurrentInstance()
					                .getExternalContext()
					                .getRequestParameterMap()
					                .get(nombreParametro);
		return stringParametro;
	}
	
	
	public static  HttpSession getHttpSession(){
	       FacesContext facesContext = FacesContext.getCurrentInstance();
	       ExternalContext externalContext = facesContext.getExternalContext();
	       HttpSession session = (HttpSession) externalContext.getSession(false);
	       return session;
	}
	
}

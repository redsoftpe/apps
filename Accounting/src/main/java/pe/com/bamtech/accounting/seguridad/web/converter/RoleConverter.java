package pe.com.bamtech.accounting.seguridad.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pe.com.bamtech.accounting.seguridad.domain.Rol;
import pe.com.bamtech.accounting.seguridad.service.RolService;


@Named
@FacesConverter(value="rolConverter", forClass=Rol.class) 
public class RoleConverter implements Converter {

	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String roleName) {
		RolService roleService = null;
		Rol role = null;
		try {
			roleService = (RolService) new InitialContext().lookup("java:app/Accounting/RolService");
			role =  roleService.find(roleName);
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Error: No se puede obtener ejb{RolService}");
		}
		return role;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if(object != null) {
			Rol role = (Rol) object;
			return role.getRolename();
		}
		return null;
	}

}

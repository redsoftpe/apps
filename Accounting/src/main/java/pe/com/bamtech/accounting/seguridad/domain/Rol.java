package pe.com.bamtech.accounting.seguridad.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol",schema="contable")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=16)
	private String rolename;

	@Column(length=140)
	private String descripcion;

	@Column(name="groupo_actual", length=16)
	private String groupoActual;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="rols")
	//@JoinColumn(name="rolename", nullable=false, insertable=false, updatable=false)
	private List<Usuario> usuarios;

	public Rol() {
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGroupoActual() {
		return this.groupoActual;
	}

	public void setGroupoActual(String groupoActual) {
		this.groupoActual = groupoActual;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
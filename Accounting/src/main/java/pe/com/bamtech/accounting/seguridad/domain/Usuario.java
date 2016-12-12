package pe.com.bamtech.accounting.seguridad.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario",schema="contable")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=16)
	private String username;

	private Integer anexo;

	@Column(nullable=false, length=32)
	private String apellido;

	@Column(length=32)
	private String area;

	@Column(length=32)
	private String cargo;

	@Column(nullable=false, length=64)
	private String email;

	@Column(nullable=false, length=16)
	private String estado;

	@Column(nullable=false, length=32)
	private String nombre;

	@Column(nullable=false, length=16)
	private String password;

	//bi-directional many-to-many association to Rol
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="USUARIO_ROL"
			, joinColumns={
				@JoinColumn(name="USERNAME", nullable=false)
				}
			, inverseJoinColumns={
				@JoinColumn(name="ROLENAME", nullable=false)
				}
			)
	private List<Rol> rols;

	public Usuario() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAnexo() {
		return this.anexo;
	}

	public void setAnexo(Integer anexo) {
		this.anexo = anexo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}
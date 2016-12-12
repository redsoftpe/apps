package pe.com.bamtech.accounting.seguridad.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARAMETRO database table.
 * 
 */
@Entity
@Table(name="parametro",schema="contable")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p",
            hints={@QueryHint(name="org.hibernate.cacheable",value="true")})
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAMETRO_ID_GENERATOR", sequenceName="SQ_PARAMETRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAMETRO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long id;

	@Column(nullable=false, length=64)
	private String nombre;

	@Column(nullable=false, length=16)
	private String tipo;

	@Column(nullable=false, length=128)
	private String valor;

	public Parametro() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
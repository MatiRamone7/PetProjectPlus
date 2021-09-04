package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.contactservices.mensajesPredeterminados.*;
import com.utn.models.Componentes.TipoDocumento;

import java.io.IOException;
import java.io.Serializable;
import javax.persistence.*;

//TODO: ver si esta clase ya se puede eliminar, cambiar todos los "User" por "Usuario"
@Entity
@Table(name="usuario")
public class User implements Serializable {
	public User() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "password")
	private String password;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;

	/*@Column(name = "tipoDocumento")
	private TipoDocumento tipoDocumento;*/

	@Column(name = "numeroDocumento")
	private Integer numeroDocumento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ongId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Organizacion ong;





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/*public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
*/
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Organizacion getOng() {
		return ong;
	}

	public void setOng(Organizacion ong) {
		this.ong = ong;
	}


/*
	public void contactar(IMensajePredet situacion) throws IOException {
		this.contacto.contactar(situacion.asunto(),situacion.cuerpo());
	}
*/
}

package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.contactservices.mensajesPredeterminados.CQRScaneado;
import com.utn.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.contactservices.mensajesPredeterminados.TipoDeComunicacion;

import java.io.IOException;
import java.io.Serializable;
import javax.persistence.*;

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

	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	@Column(name = "numeroDocumento")
	private Integer numeroDocumento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ongId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Ong ong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rolId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Rol rol;

	private ContactoUnico contacto;

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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public void contactar(IMensajePredet situacion) throws IOException {
		String asunto = TipoDeComunicacion.asunto(situacion);
		String cuerpo = TipoDeComunicacion.cuerpo(situacion);

		this.contacto.contactar(asunto,cuerpo);
	}

}

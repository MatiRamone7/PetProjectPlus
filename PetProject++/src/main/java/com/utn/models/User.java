package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utn.contactservices.Mail;
import com.utn.contactservices.SMS;
import com.utn.contactservices.Whatsapp;
import com.utn.contactservices.WhatsappWaboxService;
import com.utn.models.DarEnAdopcion.FormGiveAdoption;
import com.utn.models.DarEnAdopcion.PublicationGiveAdoption;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

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

	public void contactar() throws IOException {

		// Desarrollar test unitario

		SMS sms = new SMS();
		Mail mail = new Mail();
		Whatsapp whats = new Whatsapp();

		String asunto = "Hola";
		String cuerpo = "Mundo";
		String casilla = "mail@mail.com";
		String celular = "1162423315";

		SMS.enviarMensajeConVonage(celular, cuerpo);
		Mail.enviarMail(casilla, asunto, cuerpo);
		whats.contactar(celular, cuerpo);
	}









	public void aprobarPublicacion(PublicationGiveAdoption unaPublicaicon){
		//TODO: cambiar el estado de una formulario de NO revisado por un voluntario a revisado.
	}

	public void rechazarPublicacion(PublicationGiveAdoption unaPublicacion){
		//TODO: Borrar el formulario de la base de datos
	}


	public void darMascotaEnAdopcion(Integer petID, List<String> caracteristicasDeLaPublicacion){
		//FormGiveAdoption unFormulario = new FormGiveAdoption(this, petID, caracteristicasDeLaPublicacion);
		//cargarEnBaseDeDatos(unFormulario);
	}

	public void cargarEnBaseDeDatos(FormGiveAdoption unFormulario){
		//@loquesea
	}



}

package com.utn.models.users;

import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.roles.LogRol;
import com.utn.models.users.Comodidaes.Comodidad;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="persona")
public class Usuario extends Persona {
	//ver como queda esta entidad
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "comodidad_id", referencedColumnName = "id")
	private Set<Comodidad> comodidades;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "logRol_id")
	private List<LogRol> logRol;

	/*
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mascota_id", referencedColumnName = "id")
	private Set<Mascota> mascotas;
	*/

	@ManyToOne
	@JoinColumn(name = "organizacion_id", referencedColumnName = "id")
	private Organizacion organizacion;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "publicacionesAAprobar_id")
	private List<FormularioMascotaPerdida> publicacionesAAprobar;



	public void agregarComodidad(Comodidad comodidad){ this.comodidades.add(comodidad); }
	public void quitarComodidad(Comodidad comodidad){ this.comodidades.remove(comodidad); }

	public void agregarLogRol(LogRol log){ this.logRol.add(log); }

	/*
	public void agregarMascota(Mascota mascota){ this.mascotas.add(mascota); }
	public void quitarMascota(Mascota mascota){ this.mascotas.remove(mascota); }
	*/

	public void agregarPublicacion(FormularioMascotaPerdida publicacion){ this.publicacionesAAprobar.add(publicacion); }
	public void quitarPublicacion(FormularioMascotaPerdida publicacion){
		this.publicacionesAAprobar.remove(publicacion);
	}

	public boolean eliminarpublicacionesinncesarias(){
		//this.publicacionesAAprobar.forEach(p-> );  TODO: Se puede poner el filtrado de las publicaciones en el controller
		return true;
	}

	public List<FormularioMascotaPerdida> getPublicacionesAAprobar() { return publicacionesAAprobar; }


	public Set<Comodidad> getComodidades() {
		return comodidades;
	}

	public List<LogRol> getLogRol() {
		return logRol;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	//Login y Logout

	public String getFullName() { return  "Id: " + String.valueOf(this.getNroDocumento()) + " - Nombre: " + this.getNombre() + " " + this.getApellido(); } //TODO: completar funcion

	public void setComodidades(Set<Comodidad> comodidades) {
		this.comodidades = comodidades;
	}

	public void setLogRol(List<LogRol> logRol) {
		this.logRol = logRol;
	}

	public void setPublicacionesAAprobar(List<FormularioMascotaPerdida> publicacionesAAprobar) {
		this.publicacionesAAprobar = publicacionesAAprobar;
	}
}
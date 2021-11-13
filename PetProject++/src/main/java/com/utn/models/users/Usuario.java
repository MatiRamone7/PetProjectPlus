package com.utn.models.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.roles.LogRol;
import com.utn.models.users.Comodidades.Comodidad;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuario")
public class Usuario extends Persona {
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Comodidad> comodidades;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private List<LogRol> logRol;

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Mascota> mascotas;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
	//@JsonManagedReference
	private Organizacion organizacion;

	public void agregarComodidad(Comodidad comodidad){ this.comodidades.add(comodidad); }

	public void quitarComodidad(Comodidad comodidad){ this.comodidades.remove(comodidad); }

	public void agregarLogRol(LogRol log){ this.logRol.add(log); }
	
	public void agregarMascota(Mascota mascota){ this.mascotas.add(mascota); }
	
	public void quitarMascota(Mascota mascota){ this.mascotas.remove(mascota); }
	
	public Set<Comodidad> getComodidades() {
		return comodidades;
	}
	
	public List<LogRol> getLogRol() {
		return logRol;
	}
	
	public Set<Mascota> getMascotas() {
		return mascotas;
	}
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	public void setComodidades(Set<Comodidad> comodidades) {
		this.comodidades = comodidades;
	}
	
	public void setLogRol(List<LogRol> logRol) {
		this.logRol = logRol;
	}
	
	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	public String getFullName() { return  "Id: " + String.valueOf(this.getNroDocumento()) + " - Nombre: " + this.getNombre() + " " + this.getApellido(); }
	
}
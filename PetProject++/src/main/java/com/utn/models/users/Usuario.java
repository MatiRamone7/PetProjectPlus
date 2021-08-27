package com.utn.models.users;

import com.utn.models.*;
import com.utn.models.FormularioMascotaPerdida;
import com.utn.models.IUserLog;
import com.utn.models.roles.LogRol;
import com.utn.models.Componentes.TipoDocumento;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="personaId")
public class Usuario extends Persona implements Serializable, IUserLog {
	private List<Comodidad> comodidades;
	private List<LogRol> logRol;
	private List<Mascota> mascotas;
	private Organizacion organizacion;
	private List<FormularioMascotaPerdida> publicacionesAAprobar;

	public Usuario() {	}

	public Usuario(int id, String apellido, LocalDate fechaNacimiento, String nombre, int nroDocumento, TipoDocumento tipoDocumento, Sesion usuario) {
		super(id, apellido, fechaNacimiento, nombre, nroDocumento, tipoDocumento, usuario);
		this.comodidades = new ArrayList<>();;
		this.logRol = new ArrayList<>();
		this.mascotas = new ArrayList<>();
		this.publicacionesAAprobar = new ArrayList<>();
	}

	public void agregarComodidad(Comodidad comodidad){ this.comodidades.add(comodidad); }
	public void quitarComodidad(Comodidad comodidad){
		//int indice = this.comodidades.indexOf(comodidad);
		this.comodidades.remove(comodidad);
	}

	public void agregarMascota(Mascota mascota){ this.mascotas.add(mascota); }
	public void quitarMascota(Mascota mascota){
		//int indice = this.mascotas.indexOf(mascota);
		this.mascotas.remove(mascota);
	}

	public void agregarPublicacion(FormularioMascotaPerdida publicacion){ this.publicacionesAAprobar.add(publicacion); }
	public void quitarPublicacion(FormularioMascotaPerdida publicacion){
		this.publicacionesAAprobar.remove(publicacion);
	}
	public boolean eliminarpublicacionesinncesarias(){
		//this.publicacionesAAprobar.forEach(p-> );  TODO: terminar operacion
		return true;
	}

	public void agregarLogRol(LogRol log){ this.logRol.add(log); }


	//getter
	public List<Comodidad> getComodidades() { return comodidades; }
	public List<LogRol> getLogRol() { return logRol; }
	public List<Mascota> getMascotas() { return mascotas; }
	public void setOrganizacion(Organizacion organizacion) { this.organizacion = organizacion; }
	public Organizacion getOrganizacion() { return organizacion; }
	public List<FormularioMascotaPerdida> getPublicacionesAAprobar() { return publicacionesAAprobar; }

	@Override
	public String apellido() { return super.getApellido(); }

	@Override
	public String nombre() { return super.getNombre(); }

	@Override
	public int nroDocumento() {return super.getNroDocumento();
	}

	@Override
	public TipoDocumento tipoDocumento() { return super.getTipoDocumento(); }

	@Override
	public String usuario() { return null; } //TODO: completar funcion
}

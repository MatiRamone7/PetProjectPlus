package com.utn.models.users;

import com.utn.models.forms.IUserLog;
import com.utn.models.roles.LogRol;

import java.io.Serializable;
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

	public void agregarComodidad(Comodidad comodidad){ this.comodidades.add(comodidad); }

	public void agregarLogRol(LogRol log){ this.logRol.add(log); }

	public void agregarMascota(Mascota mascota){ this.mascotas.add(mascota); }

	public void agregarPublicacion(FormularioMascotaPerdida publicacion){ this.publicacionesAAprobar.add(publicacion); }

	public boolean eliminarpublicacionesinncesarias(){
		//this.publicacionesAAprobar.forEach(p-> );  TODO: terminar operacion
		return true;
	}

	public List<FormularioMascotaPerdida> getPublicacionesAAprobar() { return publicacionesAAprobar; }

	/*
		Login y Logout
	*/

	public void quitarComodidad(Comodidad comodidad){
		//int indice = this.comodidades.indexOf(comodidad);
		this.comodidades.remove(comodidad);
	}

	public void quitarMascota(Mascota mascota){
		//int indice = this.mascotas.indexOf(mascota);
		this.mascotas.remove(mascota);
	}

	public void agregarPublicacion(FormularioMascotaPerdida publicacion){ this.publicacionesAAprobar.add(publicacion); }
	public void quitarPublicacion(FormularioMascotaPerdida publicacion){
		this.publicacionesAAprobar.remove(publicacion);
	}

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

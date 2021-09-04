package com.utn.models.users;

import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.roles.LogRol;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persona")
public class Usuario extends Persona implements Serializable {
	//ver como queda esta entidad
	@Transient
	private List<Comodidad> comodidades;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "logRol_id")
	private List<LogRol> logRol;

	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mascota_id", referencedColumnName = "id")
	private List<Mascota> mascotas;

	@ManyToOne
	@JoinColumn(name = "organizacion_id", referencedColumnName = "id")
	private Organizacion organizacion;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "publicacionesAAprobar_id")
	private List<FormularioMascotaPerdida> publicacionesAAprobar;



	public void agregarComodidad(Comodidad comodidad){ this.comodidades.add(comodidad); }
	public void quitarComodidad(Comodidad comodidad){ this.comodidades.remove(comodidad); }

	public void agregarLogRol(LogRol log){ this.logRol.add(log); }

	public void agregarMascota(Mascota mascota){ this.mascotas.add(mascota); }
	public void quitarMascota(Mascota mascota){ this.mascotas.remove(mascota); }

	public void agregarPublicacion(FormularioMascotaPerdida publicacion){ this.publicacionesAAprobar.add(publicacion); }
	public void quitarPublicacion(FormularioMascotaPerdida publicacion){
		this.publicacionesAAprobar.remove(publicacion);
	}

	public boolean eliminarpublicacionesinncesarias(){
		//this.publicacionesAAprobar.forEach(p-> );  TODO: terminar operacion
		return true;
	}

	public List<FormularioMascotaPerdida> getPublicacionesAAprobar() { return publicacionesAAprobar; }


		//Login y Logout


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

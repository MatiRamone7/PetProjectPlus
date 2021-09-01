package com.utn.models.forms;

import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.TipoDocumento;

import javax.persistence.*;
import java.util.List;

public class FormularioMascotaPerdida extends PersonaFormulario implements IUserLog {

    private List<String> caracteristicasDeLaPublicacionDelHogar;

    private String descripcionEstadoMascota;

    private Mascota.Especie especie;

    private List<EstadoFormulario> estados;

    private List<Foto> fotos;

    /*
    Falta HogarDeTransito
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    private Mascota mascota;

    private Direccion lugarEncuentroMascota;

    private Organizacion organizacion;

    private Mascota.Sexo sexo;

    private String tamanio;


    /*
    Interface User Log
    */

    @Override
    public String apellido() {
        return null;
    }

    @Override
    public String nombre() {
        return null;
    }

    @Override
    public int nroDocumento() {
        return 0;
    }

    @Override
    public TipoDocumento tipoDocumento() {
        return null;
    }

    @Override
    public String usuario() {
        return null;
    }

    /*
        actualizarEstado y estadoActual son seter y getter de estado, la primer property
    */
}

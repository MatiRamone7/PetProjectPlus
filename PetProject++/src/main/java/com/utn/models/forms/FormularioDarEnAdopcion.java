package com.utn.models.forms;

import com.utn.models.mascotas.Mascota;
import com.utn.models.ongs.Organizacion;
import com.utn.models.users.Usuario;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="formularioDarEnAdopcion")
public class FormularioDarEnAdopcion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @OneToOne()
    @JoinColumn(name = "mascotaID")
    private Mascota mascota;

    @ManyToOne()
    @JoinColumn(name = "ongId")
    private Organizacion organizacion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoFormularioDarEnAdopcionId")
    private List<EstadoFormulario> estado;

    @OneToMany(mappedBy = "formularioDarEnAdopcion", cascade = CascadeType.ALL)
    private List<PreguntaRespuestaAdoptante> preguntas;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public List<PreguntaRespuestaAdoptante> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaRespuestaAdoptante> preguntas) {
        this.preguntas = preguntas;
    }

    public List<EstadoFormulario> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoFormulario> estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public String agregarAListaDeSugerencias(String sugerencias) {
        String datosFormulario = "- Nombre de la mascota: " + this.mascota.getNombre() + '\n' 
       + "- Especie: " + this.mascota.getEspecie() + '\n'
       + "- Sexo: " + this.mascota.getSexo() + '\n'
       + "- ONG responsable: " + this.organizacion.getNombre() + '\n'
       + "- Duenio actual: "  + this.mascota.getUsuarioId().getNombre() + '\n' 
       + " ========================================================================== " + '\n' + '\n'; 

        return sugerencias + datosFormulario;
    }
}
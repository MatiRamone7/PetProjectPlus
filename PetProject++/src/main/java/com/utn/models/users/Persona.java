package com.utn.models.users;

import com.utn.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.models.ContactoUnico;
import com.utn.models.Direccion;
//import com.utn.models.Sesion;
import com.utn.models.Componentes.TipoDocumento;

import javax.persistence.*;

import java.io.IOException;
import java.io.Serializable;
import java.time.*;

@Entity
@Table(name = "Persona")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "apellido", length = 40)
    protected String apellido;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected ContactoUnico contacto;

    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    protected LocalDate fechaNacimiento;

    @Column(name = "nombre", length = 40)
    protected String nombre;

    @Column(name = "nroDocumento")
    protected int nroDocumento;

    @Enumerated(EnumType.ORDINAL)
    protected TipoDocumento tipoDocumento;

    //no se que tipo de mapeo debe llevar
    protected Sesion usuario;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected Direccion direccion;

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }

    public Persona(int id, String apellido, LocalDate fechaNacimiento, String nombre, int nroDocumento, TipoDocumento tipoDocumento, Sesion usuario) {
        this.id = id;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
    }

    public void login(){

    }

    public void logout(){

    }

    //getter and setter
    public Integer getId() { return id; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public ContactoUnico getContacto() { return contacto; }
    public void setContacto(ContactoUnico contacto) { this.contacto = contacto; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getNroDocumento() {return nroDocumento;}
    public void setNroDocumento(int nroDocumento) {this.nroDocumento = nroDocumento;}

    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public Sesion getUsuario() { return usuario; }
    public void setUsuario(Sesion usuario) { this.usuario = usuario; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public void contactar(IMensajePredet situacion) throws IOException {
        this.contacto.contactar(situacion.asunto(),situacion.cuerpo());
	}
}
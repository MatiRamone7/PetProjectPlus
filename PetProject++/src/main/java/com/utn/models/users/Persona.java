package com.utn.models.users;

import com.utn.models.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.models.forms.Direccion;
import javax.persistence.*;
import java.io.IOException;
import java.time.*;

@MappedSuperclass
public abstract class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "apellido")
    protected String apellido;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contactoId")
    protected ContactoUnico contacto;

    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    protected LocalDate fechaNacimiento;

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "nroDocumento")
    protected int nroDocumento;

    @Enumerated(EnumType.STRING)
    protected TipoDocumento tipoDocumento;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "sesionId")
    protected Sesion sesion;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    protected Direccion direccion;

    public Persona() {/*this.sesion = new Sesion("Daniel", "contrasenia");*/}

    public Persona(String apellido, LocalDate fechaNacimiento, String nombre, int nroDocumento, TipoDocumento tipoDocumento, Sesion sesion, Direccion direccion) {
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.sesion = sesion;
        this.direccion = direccion;
    }

    public void login(){

    }

    public void logout(){

    }

    //getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

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

    public Sesion getSesion() {
        return sesion;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public void contactar(IMensajePredet situacion) throws IOException {
        this.contacto.contactar(situacion.asunto(),situacion.cuerpo());
    }
}
package com.utn.models.forms;

import java.time.LocalDate;

import com.utn.models.users.ContactoUnico;
import com.utn.models.users.TipoDocumento;

import javax.persistence.*;

@MappedSuperclass
public abstract class PersonaFormulario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contacto_id")
    private ContactoUnico contacto;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "direccion_id")

    private Direccion direccion;

    @Column(name = "fecha_de_nacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Column(name = "nro_documento")
    private int nroDocumento;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo_documento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContactoUnico getContacto() {
        return contacto;
    }

    public void setContacto(ContactoUnico contacto) {
        this.contacto = contacto;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipo_documento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipo_documento = tipoDocumento;
    }

    public String getFullName() {
        return  "Id: " + String.valueOf(this.getNroDocumento()) + " - Nombre: " + this.getNombre() + " " + this.getApellido();
    }
}

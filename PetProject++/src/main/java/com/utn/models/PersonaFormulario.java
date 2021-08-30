package com.utn.models;

import java.time.LocalDate;

import com.utn.models.Componentes.TipoDocumento;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contactoID", referencedColumnName = "id")
    private ContactoUnico contacto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="direccionID", referencedColumnName = "id")
    private Direccion direccion;

    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Column(name = "nroDocumento")
    private int nroDocumento;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;


    public String apellido(){
        return apellido;
    }

    public String nombre(){
        return nombre;
    }

    public int nroDocumento(){
        return nroDocumento;
    }

    public TipoDocumento tipoDocumento(){
        return tipoDocumento;
    }

    public String usuario(){
        return "Ejemplo";
    }
}

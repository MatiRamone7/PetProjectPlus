package com.utn.models.ongs;

import javax.persistence.*;
@Entity
@Table(name="preguntas_adopcion")
public class PreguntaAdoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_organizacion") //puede ser esto un many to one?
    public int idOrganizacion;

    @Column(name = "pregunta")
    public String pregunta;

    @Enumerated(EnumType.STRING)
    public TipoPregunta tipoPregunta;


}

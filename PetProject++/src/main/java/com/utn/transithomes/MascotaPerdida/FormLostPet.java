package com.utn.transithomes.MascotaPerdida;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import com.utn.models.Characteristic;
import com.utn.models.Ong;
import com.utn.transithomes.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@Table(name="FormularioMascotaPerdida")
public class FormLostPet implements Serializable{
    public FormLostPet(){}
        //Datos sobre el rescatista
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
        @Basic
        @Column(name = "id")
        private Integer id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "apellido")
        private String apellido;

        @Column(name = "fechaDeNacimiento")
        private Date fechaDeNacimiento;

        @Column(name = "tipoDocumento")
            private String tipoDocumento;

        @Column(name = "nroDocumento")
        private int nroDocumento;


        @JoinColumn(name = "direccion_Id")
        @OneToOne(fetch = FetchType.LAZY)
        @Column(name = "direccion")
        private Direction direccion;

        @Column(name = "telefono")
        private String telefono;

        @Column(name = "mail")
        private String mail;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ongId")
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private Ong ong;

        //////Datos sobre la mascota/////
        @Column(name = "descripcion")
        private String descripcion;

        @Column(name = "patronDistintivo")
        private String patronDistintivo;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "caracteristicaXaviso",
            joinColumns = { @JoinColumn(name = "idAviso") },
            inverseJoinColumns = { @JoinColumn(name="caracteristicaId") }
    )
    private Set<Characteristic> caracteristicSet = new HashSet<>();




    @ElementCollection
    private List<String> caracteristicasDeLaPublicacionDelHogar;

    @ElementCollection
    private List<BitArray> fotos;
    //TODO: estas caracteristicas serían las siguientes con sus respectivos valores


    private String especie;
    private String tamanio;
    //@Column(name = "lugarEncontrado")
    //private Ubication lugarEncontrado;
    //private String direccion;
    private double lat;
    @SerializedName("long")
    private double lon;
        /*private String raza;
        private String sexo;
        private String colorPrincipal;
        private String colorSecundario;
        private Boolean esterilizado;
        private Boolean rabo;
        private Boolean discapacidad;
        private String tamanio;
      */


        //private List<? extends Caracteristica> ListaDeCaract;




        public void guardarFormularioEnBD(){
            //TODO: preguntar como pasar todos los datos del formulario al controller para manipularlo


        }






        public List<Home> buscarHogarDeTransito(){
            ServiceRefugios serviciosRefugios = ServiceRefugios.getInstancia();
            List<Home> listadaAuxiliar = new ArrayList<>();
            RefugeeList listadoDeRefugios;
            int offset = 0;
            try {
                while (true) {
                    offset++;

                    listadoDeRefugios = serviciosRefugios.listadoDeRefugios(offset);
                    listadaAuxiliar.addAll(listadoDeRefugios.hogares.stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(this)).collect(Collectors.toList()));
                }
            }
            catch (Exception e){
            }
            return listadaAuxiliar;
        }
























        public FormLostPet(String especie, String tamanio, Double latitud, Double longitud, List<String> caracteristicasDeLaPublicacionDelHogar) {
            this.especie = especie;
            this.tamanio = tamanio;
            this.lat = latitud;
            this.lon = longitud;
            this.caracteristicasDeLaPublicacionDelHogar = caracteristicasDeLaPublicacionDelHogar;
        }



        public String getEspecie() {
            return especie;
        }

        public void setEspecie(String especie) {
            this.especie = especie;
        }



        public String getTamanio() {
            return tamanio;
        }

        public void setTamanio(String tamanio) {
            this.tamanio = tamanio;
        }


        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLong() {
            return lon;
        }

        public void setLong(double lon) {
            this.lon = lon;
        }



        public List<String> getCaracteristicasDeLaPublicacionDelHogar() {
            return caracteristicasDeLaPublicacionDelHogar;
        }

        public void setCaracteristicasDeLaPublicacionDelHogar(List<String> caracteristicasDeLaPublicacionDelHogar) {
            this.caracteristicasDeLaPublicacionDelHogar = caracteristicasDeLaPublicacionDelHogar;
        }
}
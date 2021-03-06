package com.utn.transithomes;

import com.utn.models.mascotas.Mascota;
import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.utils.Coordenadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hogar {

    private String id;
    private String nombre;
    private Ubication ubicacion;
    private String telefono;
    private Admisiones admisiones;
    private int capacidad;
    private int lugares_disponibles;
    private boolean patio;
    private List<String> caracteristicas;

    public class Admisiones{
        public boolean perros;
        public boolean gatos;

        public boolean isPerros() {
            return perros;
        }

        public void setPerros(boolean perros) {
            this.perros = perros;
        }

        public boolean isGatos() {
            return gatos;
        }

        public void setGatos(boolean gatos) {
            this.gatos = gatos;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubication getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubication ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Admisiones getAdmisiones() {
        return admisiones;
    }

    public void setAdmisiones(Admisiones admisiones) {
        this.admisiones = admisiones;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getLugares_disponibles() {
        return lugares_disponibles;
    }

    public void setLugares_disponibles(int lugares_disponibles) {
        this.lugares_disponibles = lugares_disponibles;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean cumpleRequisitosDelHogar(/*FormLostPet*/FormularioMascotaPerdida formularioMascotaPerdida){
        return (aceptaEspecie(formularioMascotaPerdida.getEspecie()) &&                                      //Especie
                validacionPatio(formularioMascotaPerdida.getTamanio()) &&                                    //Tama??o
                cercaDelLugarEncontrado(formularioMascotaPerdida.getLugarEncontrado(), formularioMascotaPerdida.getDistanciaMaximaEnKM()) &&                    //Lugar Encontrado
                cumpleCaracteristicas(formularioMascotaPerdida.getCaracteristicasDeLaPublicacionDelHogar()));        //Otras Caracteristicas
    }

    private boolean aceptaEspecie(Mascota.Especie especie){                 //Especie
        if(especie == Mascota.Especie.PERRO){                               // Retorna dependiendo de si el hogar acepta (admisiones) o no a los perros o a los gatos
            return this.admisiones.perros;
        }
        else{
            return this.admisiones.gatos;
        }
    }

    private boolean validacionPatio(String tamanio){            //Tama??o
        if(tamanio == "Grande" || tamanio == "Mediano"){
            return this.patio;
        }
        return true;
    }

    private boolean cercaDelLugarEncontrado(Ubication lugarEncontrado, Double distanciaMaximaEnKM){         //Lugar Encontrado
        return (Coordenadas.distanciaCoord(this.ubicacion.getLat(), this.ubicacion.getLong(), lugarEncontrado.getLat(), lugarEncontrado.getLong()) <= distanciaMaximaEnKM);
    }

    private boolean cumpleCaracteristicas(List<String> caracteristicasDeLaPublicacion){             //Otras Caracteristicas
        //this.caracteristicas.forEach(car -> caracteristicasDeLaPublicacion.contains(car));
        return this.caracteristicas.stream().allMatch(car -> caracteristicasDeLaPublicacion.contains(car));
    }

    /*
    public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371;//en kil??metros

        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);

        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);

        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
    }*/
    public static List<String> asignarCaracteristicasHogar(Map<String, String> body){
        List<String> caracteristicas = new ArrayList<>();

        if(body.get("Tranquilo") != null){
            caracteristicas.add(body.get("Tranquilo"));
        }
        if(body.get("Pacifico") != null){
            caracteristicas.add(body.get("Pacifico"));
        }
        if(body.get("Manso") != null){
            caracteristicas.add(body.get("Manso"));
        }
        if(body.get("Delgado") != null){
            caracteristicas.add(body.get("Delgado"));
        }
        if(body.get("Amistoso") != null){
            caracteristicas.add(body.get("Amistoso"));
        }

        return caracteristicas;
    }
}

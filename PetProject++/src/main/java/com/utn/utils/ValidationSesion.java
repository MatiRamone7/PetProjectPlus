package com.utn.utils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ValidationSesion implements IValidationSesion {
    private static final int CARACTERES_MINIMOS_PASS = 8;
    private static final int CARACTERES_MAXIMOS_PASS = 64;
    private static final String STATUS_OK = "OK";
    private static final String REQUIERE_LETRA_MAYUSCULA = "Requiere al menos una letra mayuscula";
    private static final String REQUIERE_LETRA_MINUSCULA = "Requiere al menos una letra minuscula";
    private static final String REQUIERE_CARACTER_ESPECIAL = "Requiere al menos un caracter especial";
    private static final String REQUIERE_NUMERO = "Requiere al menos un caracter numerico";
    private static final String USUARIO_PASS_IGUALES = "Requiere usuario y la contraseÃ±a  distintos";
    private static final String PASS_SIMPLE = "ContraseÃ±a muy simple";
    private static final String PASS_LONGITUD = "La contraseÃ±a debe tener un largo entre 8 y 64 caracteres";
    private static final String PATH_PASSWORDS = "validation\\10k-worst-passwords.txt";

    private List<String> passwordsFrecuentes;

    public ValidationSesion() {
        try {
            passwordsFrecuentes = ArchivosUtils.devolverContenido(PATH_PASSWORDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SesionResponse validarUsuarioyPass(String usuario, String pass){
        SesionResponse validador = new SesionResponse();

        pass = this.eliminarEspaciosConsecutivos(pass);

        validador.add(this.validarUsuarioYPassDistintos(usuario, pass));
        validador.add(this.validarLongitud(pass));
        validador.add(this.validarConListaNegra(pass));
        validador.add(this.validarComplejidadContraseña(pass));

        return  validador;
    }

    public SesionResponse validarUsuarioYPassDistintos(String usuario, String pass ) {
        return new SesionResponse(!pass.toLowerCase().contains(usuario.toLowerCase()) && !usuario.toLowerCase().contains(pass.toLowerCase()), USUARIO_PASS_IGUALES );
    }

    public SesionResponse validarLongitud(String pass){
        return new SesionResponse(MathUtils.between(pass.length(),CARACTERES_MINIMOS_PASS,CARACTERES_MAXIMOS_PASS), PASS_LONGITUD );
    }

    public String eliminarEspaciosConsecutivos(String sValue){
        return sValue.trim().replaceAll("\\s+", " ");
    }

    public SesionResponse validarConListaNegra(String password ){
        return new SesionResponse(!ArchivosUtils.busquedaBinariaString(passwordsFrecuentes, password.toLowerCase(Locale.ROOT)), PASS_SIMPLE );
    }

    public SesionResponse validarComplejidadContraseña(String pass){

        SesionResponse response = new SesionResponse();

        response.add(this.validarAlMenosUnaLetraMayuscula(pass));
        response.add(this.validarAlMenosUnaLetraMinuscula(pass));
        response.add(this.validarAlMenosUnSimbolo(pass));
        response.add(this.validarAlMenosUnNumero(pass));

        return response;
    }

    protected SesionResponse validarAlMenosUnaLetraMayuscula(String pass){
        return new SesionResponse(pass.matches(".*[A-Z].*") , REQUIERE_LETRA_MAYUSCULA );
    }

    protected SesionResponse validarAlMenosUnaLetraMinuscula(String pass){
        return new SesionResponse(pass.matches(".*[a-z].*"), REQUIERE_LETRA_MINUSCULA );
    }

    protected SesionResponse validarAlMenosUnSimbolo(String pass){
        return new SesionResponse(pass.matches(".*[@#$%^&+=!,;_\\s-].*"), REQUIERE_CARACTER_ESPECIAL );
    }

    protected SesionResponse validarAlMenosUnNumero(String pass){
        return new SesionResponse(pass.matches(".*[0-9].*"), REQUIERE_NUMERO);
    }
}

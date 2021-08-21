package com.utn.contactservices.mensajesPredeterminados;

public class CInteresDeAdopcion implements IMensajePredet  {
    public String textoDeUsuario = null;

    public CInteresDeAdopcion(String input){
        textoDeUsuario = input;
    }

    public String cuerpo(){
        String retorno = "Alguien ha mostrado interés en adoptar a tu mascota \t " + textoDeUsuario;
        return retorno;
    }; 

    public String asunto (){
        return "Interés de adopción";
    };

    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
}


package com.utn.contactservices.mensajesPredeterminados;

public class CInteresDeAdopcion implements IMensajePredet  {
    public String mensajePredet (String textoDeUsuario){
        String retorno = "Alguien ha mostrado interés en adoptar a tu mascota \t " + textoDeUsuario;
        return retorno;
    }; 

    public String asunto (){
        return "Interés de adopción";
    };
}

package com.utn.models.contactservices.mensajesPredeterminados;

public class CQRScaneado implements IMensajePredet {
    public String textoDeUsuario = null;

    public CQRScaneado(String input){
        textoDeUsuario = input;
    }

    public String cuerpo(){
        String retorno = "Alguien ha escaneado el QR de tu mascota \n " + textoDeUsuario;
        return retorno;
    };

    public String asunto (){
        return "QR de mascota escaneado";
    };

    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
}

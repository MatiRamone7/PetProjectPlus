package com.utn.contactservices.mensajesPredeterminados;

public class CQRScaneado implements IMensajePredet {
    public String mensajePredet (String textoDeUsuario){
        String retorno = "Alguien ha escaneado el QR de tu mascota \t " + textoDeUsuario;
        return retorno;
    };

    public String asunto (){
        return "QR de mascota escaneado";
    };
}

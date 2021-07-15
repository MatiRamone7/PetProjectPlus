package com.utn.contactservices.mensajesPredeterminados;

public class CQRScaneado implements IMensajePredet {
    public String mensajePredet (String textoDeUsuario){
        String retorno = "Se ha escaneado el QR de su mascota \t " + textoDeUsuario;
        return retorno;
    };
}

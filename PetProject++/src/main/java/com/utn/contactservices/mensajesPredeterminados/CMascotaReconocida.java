package com.utn.contactservices.mensajesPredeterminados;

public class CMascotaReconocida implements IMensajePredet  {
    public String mensajePredet (String textoDeUsuario){
        String retorno = "La mascota que reportaste como perdida fue reconocida por su dueño. \t " + textoDeUsuario;
        return retorno;
    }; 

    public String asunto (){
        return "Mascota reconocida";
    };
}

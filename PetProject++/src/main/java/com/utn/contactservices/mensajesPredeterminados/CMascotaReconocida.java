package com.utn.contactservices.mensajesPredeterminados;

public class CMascotaReconocida implements IMensajePredet  {
    public String textoDeUsuario = null;

    public CMascotaReconocida(String input){
        textoDeUsuario = input;
    }

    public String cuerpo(){
        String retorno = "La mascota que reportaste como perdida fue reconocida por su dueño. \t " + textoDeUsuario;
        return retorno;
    }; 

    public String asunto (){
        return "Mascota reconocida";
    };

    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
}

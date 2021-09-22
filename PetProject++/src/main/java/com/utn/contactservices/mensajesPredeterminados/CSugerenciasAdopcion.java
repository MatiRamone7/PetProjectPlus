package com.utn.contactservices.mensajesPredeterminados;

public class CSugerenciasAdopcion implements IMensajePredet  {
    public String textoDeUsuario = null;

    public CSugerenciasAdopcion(String input){
        textoDeUsuario = input;
    }

    public String cuerpo(){
        String retorno = "Considerando adoptar?" + "Aquí te traemos una lista de mascotas que están buscando dueño \n " + textoDeUsuario;
        return retorno;
    };

    public String asunto (){
        return "Te traemos una serie de sugerecias para adoptar";
    };

    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
}



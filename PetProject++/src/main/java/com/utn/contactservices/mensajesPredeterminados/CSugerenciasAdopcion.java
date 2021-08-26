package com.utn.contactservices.mensajesPredeterminados;

public class CSugerenciasAdopcion implements IMensajePredet  {
    public String textoDeUsuario = null;

    public CSugerenciasAdopcion(String input){
        textoDeUsuario = input;
    }

    public String cuerpo(){
        String listaSugerencias = null; //generar aca la lista de sugerencias de alguna manera;
        String retorno = "Considerando adoptar?" + "Aquí te traemos una lista de mascotas que están buscando dueño \t " + listaSugerencias;
        return retorno;
    };

    public String asunto (){
        return "Te traemos una serie de sugerecias para adoptar";
    };

    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
}


